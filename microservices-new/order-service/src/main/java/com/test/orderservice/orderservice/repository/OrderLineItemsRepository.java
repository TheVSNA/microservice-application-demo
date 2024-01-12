package com.test.orderservice.orderservice.repository;

import com.test.orderservice.orderservice.model.OrderLineItems;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface OrderLineItemsRepository extends MongoRepository<OrderLineItems,String> {
    public Optional<OrderLineItems> findByCodeAndPriceAndQuantity(String code, BigDecimal price, Integer quantity);
}
