package com.test.inventoryservice.inventoryservice;

import com.test.inventoryservice.inventoryservice.model.Inventory;
import com.test.inventoryservice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//No need to insert @EnableEurekaClient because it is deprecated
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//		return args -> {
//			Inventory i1 = new Inventory();
//			i1.setCode("product_1");
//			i1.setQuantity(100);
//
//			Inventory i2 = new Inventory();
//			i2.setCode("product_2");
//			i2.setQuantity(0);
//
//			if(inventoryRepository.findByCode(i1.getCode()).isEmpty())
//				inventoryRepository.save(i1);
//			if(inventoryRepository.findByCode(i2.getCode()).isEmpty())
//				inventoryRepository.save(i2);
//
//		};
//	}
}
