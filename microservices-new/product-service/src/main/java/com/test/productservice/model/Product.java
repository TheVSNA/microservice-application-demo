package com.test.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
@Builder permette la creazione di oggetti in questo modo:
Person.builder()
.name("Adam Savage")
.city("San Francisco")
.job("Mythbusters")
.job("Unchained Reaction")
.build();
 */
@Data
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String price;
}
