package com.petwal.repository;

import com.petwal.repository.model.PickEntity;
import org.springframework.data.repository.CrudRepository;

public interface PickRepository extends CrudRepository<PickEntity, String> {
}
