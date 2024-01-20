package com.test.orderservice.orderservice.service;

import com.test.orderservice.orderservice.dto.OrderLineItemsDto;
import com.test.orderservice.orderservice.dto.OrderRequest;
import com.test.orderservice.orderservice.event.OrderPlacedEvent;
import com.test.orderservice.orderservice.model.Order;
import com.test.orderservice.orderservice.model.OrderLineItems;
import com.test.orderservice.orderservice.repository.OrderLineItemsRepository;
import com.test.orderservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderLineItemsRepository orderLineItemsRepository;
    private final WebClient.Builder webClientBuilder;
    //private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;
    private final KafkaTemplate<String,String> kafkaTemplate;
    public String placeOrder(OrderRequest or){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());


        List<OrderLineItems> list  = or.getOrderLineItemsDtoList().stream().map(o->mapToDto(o)).toList();

        Boolean allPresents=true;
        for(OrderLineItems oli:list){
            Boolean res = webClientBuilder.build().get()
                    .uri("http://inventory-service/api/inventory/"+oli.getCode())   //spring eureka allow to link names to application, so that we do not need to hardcode urls
                    //.uri("http://localhost:8082/api/inventory/"+oli.getCode())
                    .retrieve()
                    .bodyToMono(Boolean.class).block();
            if(!res)
                allPresents=false;
        }

        if(allPresents){
            List<OrderLineItems> savedlist= new ArrayList<>();
            for(OrderLineItems oli:list){
                Optional<OrderLineItems> optional = orderLineItemsRepository.findByCodeAndPriceAndQuantity(oli.getCode(),oli.getPrice(),oli.getQuantity());
                if(optional.isEmpty())
                    savedlist.add(orderLineItemsRepository.save(oli));
                else
                    savedlist.add(optional.get());
            }
            order.setOrderLineItemsList(savedlist);
            orderRepository.save(order);
            //kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
            kafkaTemplate.send("notificationTopic",order.getOrderNumber());
            return "Order placed successfully";
        }else{
            return "One of the items is out of stock";
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto o) {
        OrderLineItems oli = new OrderLineItems();
        oli.setPrice(o.getPrice());
        oli.setQuantity(o.getQuantity());
        oli.setCode(o.getCode());
        return oli;
    }
}
