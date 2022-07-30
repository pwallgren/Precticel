package com.petwal.service;

import com.petwal.repository.ProductRepository;
import com.petwal.repository.model.Product;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(final Product product) {
        productRepository.save(product);
    }
}
