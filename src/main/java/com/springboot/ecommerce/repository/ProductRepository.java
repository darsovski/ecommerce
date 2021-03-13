package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findByCategory(String category);
    void deleteByName(String name);
    Optional<Product> findByName(String name);
    Optional<Product> findById(Long id);

    /*List<Product> findAllByOrderByPriceAsc(double price);
    List<Product> findAllByOrOrderByPriceDesc(double price);*/
}
