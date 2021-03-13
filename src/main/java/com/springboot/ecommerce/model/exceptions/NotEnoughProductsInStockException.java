package com.springboot.ecommerce.model.exceptions;

public class NotEnoughProductsInStockException extends RuntimeException {
    public NotEnoughProductsInStockException() {
        super(String.format("Shopping Cart is empty"));
    }
}
