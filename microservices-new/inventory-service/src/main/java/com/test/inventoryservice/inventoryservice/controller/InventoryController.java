package com.test.inventoryservice.inventoryservice.controller;

import com.test.inventoryservice.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor

public class InventoryController {
private final InventoryService inventoryService;
    @GetMapping("/{code}")
    public boolean isInStock(@PathVariable String code){

        return inventoryService.isInStock(code);
    }
}
