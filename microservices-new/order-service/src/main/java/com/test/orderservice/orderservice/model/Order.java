package com.test.orderservice.orderservice.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    private String   id;
    private String orderNumber;
    @DBRef
    private List<OrderLineItems> orderLineItemsList;
}
