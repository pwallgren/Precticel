package com.petwal.config;

import com.petwal.repository.OrderRepository;
import com.petwal.rest.service.ApiOrderService;
import com.petwal.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OrderService pickingService(final OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    public ApiOrderService apiOrderService(final OrderService orderService) {
        return new ApiOrderService(orderService);
    }
}
