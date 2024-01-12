package com.test.inventoryservice.inventoryservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Inventory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Inventory {
    @Id
    private String id;
    private String code;
    private Integer quantity;
}
