package com.petwal.config;

import com.petwal.repository.ItemRepository;
import com.petwal.repository.OrderRepository;
import com.petwal.service.OrderService;
import com.petwal.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductService productService(final ItemRepository itemRepository) {
        return new ProductService(itemRepository);
    }

    @Bean
    public OrderService pickingService(final OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }
}
