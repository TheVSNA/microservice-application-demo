package com.test.inventoryservice.inventoryservice.service;

import com.test.inventoryservice.inventoryservice.model.Inventory;
import com.test.inventoryservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String code){
        Optional<Inventory> temp = inventoryRepository.findByCode(code);
        return (temp.isPresent() && temp.get().getQuantity()>0);
    }
}
