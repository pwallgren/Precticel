package com.petwal.service;

import com.petwal.repository.ItemRepository;
import com.petwal.repository.model.ItemEntity;

public class ProductService {

    private ItemRepository itemRepository;

    public ProductService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveProduct(final ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
    }
}
