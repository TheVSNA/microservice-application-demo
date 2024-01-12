package com.test.inventoryservice.inventoryservice.repository;

import com.test.inventoryservice.inventoryservice.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory,String> {
    public Optional<Inventory> findByCode(String code);
}
