package com.test.productservice.service;

import com.test.productservice.dto.ProductRequest;
import com.test.productservice.dto.ProductResponse;
import com.test.productservice.model.Product;
import com.test.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest pr){
        Product p = Product.builder().name(pr.getName()).description(pr.getDescription()).price(pr.getPrice()).build();
        productRepository.save(p);
        log.info("Product "+p.getId()+" saved");
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> list =  productRepository.findAll();
        return list.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product p) {
        return  ProductResponse.builder().id(p.getId()).name(p.getName()).description(p.getDescription()).price(p.getPrice()).build();
    }
}
