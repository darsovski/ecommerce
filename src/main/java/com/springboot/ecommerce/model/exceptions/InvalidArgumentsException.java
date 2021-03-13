package com.springboot.ecommerce.model.exceptions;

public class InvalidArgumentsException extends RuntimeException {

    public InvalidArgumentsException() {
        super("Invalid arguments exception");
    }
}
