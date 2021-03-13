package com.springboot.ecommerce.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class ShoppingCartIsAlreadyCreated extends RuntimeException {
    public ShoppingCartIsAlreadyCreated(Long userid) {
        super(String.format("Shopping cart is already created for user: %d", userid));
    }
}
