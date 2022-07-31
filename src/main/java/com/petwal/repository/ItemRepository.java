package com.petwal.repository;

import com.petwal.repository.model.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, String> {
}
