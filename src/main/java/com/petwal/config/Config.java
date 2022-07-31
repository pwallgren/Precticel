package com.petwal.config;

import com.petwal.repository.ItemRepository;
import com.petwal.repository.OrderRepository;
import com.petwal.service.PickingService;
import com.petwal.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    public ProductService productService(final ItemRepository itemRepository) {
        return new ProductService(itemRepository);
    }

    @Bean
    public PickingService pickingService(final OrderRepository orderRepository) {
        return new PickingService(orderRepository);
    }
}
