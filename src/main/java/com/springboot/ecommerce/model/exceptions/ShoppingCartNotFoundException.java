package com.springboot.ecommerce.model.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException {
    public ShoppingCartNotFoundException() {
        super(String.format("Shopping card was not found"));
    }
}
