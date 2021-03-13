package com.springboot.ecommerce.model.exceptions;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException() {super("Invalid Username exception");}
}
