package com.test.orderservice.orderservice.controller;

import com.test.orderservice.orderservice.dto.OrderRequest;
import com.test.orderservice.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j

public class OrderController {
    private final OrderService orderService;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "userService",fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody OrderRequest or) {
         String res = orderService.placeOrder(or);
         log.info(res);
         return res;
    }



    @GetMapping("/test")

    public Boolean test(){
        return restTemplate.getForObject("http://localhost:8082/api/inventory/product_1",Boolean.class);
    }
    public String fallbackMethod(Exception e){
        e.printStackTrace();
        return "error";

    }
}
