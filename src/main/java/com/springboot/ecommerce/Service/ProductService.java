package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.model.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(String name, String description, Integer quantity, Double weight, Double price/*, Long categoryId*/);

    Optional<Product> save(ProductDto productDto);

   // Optional<Product> edit(Long id, String name, Double price, Double quantity/*, Long category*/);

    Optional<Product> edit(Long id, ProductDto productDto);

    void deleteById(Long id);
}
