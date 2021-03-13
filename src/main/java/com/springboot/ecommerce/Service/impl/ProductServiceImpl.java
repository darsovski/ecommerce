package com.springboot.ecommerce.Service.impl;


import com.springboot.ecommerce.Service.ProductService;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.model.dto.ProductDto;
import com.springboot.ecommerce.model.exceptions.ProductNotFoundException;
import com.springboot.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
/*
    private final CategoryRepository categoryRepository;
*/

    public ProductServiceImpl(ProductRepository productRepository
                              /*CategoryRepository categoryRepository*/) {
        this.productRepository = productRepository;
        //this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(String name, String description,Integer quantity, Double weight, Double price/*, Long categoryId*/) {
      /*  Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
*/

        this.productRepository.deleteByName(name);
        return Optional.of(this.productRepository.save(new Product(name,description,quantity,weight,price/*,category*/)));
    }

    @Override
    public Optional<Product> save(ProductDto productDto) {
/*        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategory()));*/

        this.productRepository.deleteByName(productDto.getName());
        return Optional.of(this.productRepository.save(new Product(productDto.getName(),productDto.getDescription() ,
                                                    productDto.getQuantity() ,productDto.getWeight() ,productDto.getPrice()/*,category*/)));
    }

/*    @Override
    @Transactional
    public Optional<Product> edit(Long id, String name, Double price, Double quantity) {

        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

   *//*     Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        product.setCategory(category);*//*

        return Optional.of(this.productRepository.save(product));
    }*/

    @Override
    public Optional<Product> edit(Long id, ProductDto productDto) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

   /*     Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategory()));
        product.setCategory(category);*/


        return Optional.of(this.productRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
