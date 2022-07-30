package com.petwal.controller;

import com.petwal.repository.model.Product;
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
        productService.saveProduct(new Product("Petter"));
        return "Hello WOrld!";
    }
}
