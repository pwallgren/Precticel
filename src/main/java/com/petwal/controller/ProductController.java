package com.petwal.controller;

import com.petwal.repository.model.ItemEntity;
import com.petwal.repository.model.ItemTypeEntity;
import com.petwal.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String createProduct() {
        productService.saveProduct(ItemEntity.builder()
                .name("Kudde 1000")
                .id("2459AB")
                .productType(ItemTypeEntity.of("13535AA", "KUDDE"))
                .build());
        return "Hello WOrld!";
    }
}
