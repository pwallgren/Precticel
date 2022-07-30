package com.petwal.config;

import com.petwal.repository.ProductRepository;
import com.petwal.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    public ProductService productService(final ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
