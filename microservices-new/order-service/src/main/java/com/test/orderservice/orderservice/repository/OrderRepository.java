package com.test.orderservice.orderservice.repository;

import com.test.orderservice.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
