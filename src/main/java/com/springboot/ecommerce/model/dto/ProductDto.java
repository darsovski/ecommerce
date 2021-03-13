package com.springboot.ecommerce.model.dto;


import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private String description;

    private Integer quantity;

    private Double weight;

    private Double price;

    //private Long category;

    public ProductDto() {
    }

    public ProductDto(String name, String description, Integer quantity, Double weight, Double price /*, Long category*/) {
        this.name = name;
        this.price = price;
        this.description=description;
        this.weight=weight;
        this.quantity = quantity;
        //this.category = category;
    }
}
