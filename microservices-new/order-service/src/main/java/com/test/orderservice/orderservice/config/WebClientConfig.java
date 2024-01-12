package com.test.orderservice.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced   //if there are multiple services with the same name in spring eureka,
                    // @loadbalanced is used to automatically balance the load between all the services with the same name
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }
}
