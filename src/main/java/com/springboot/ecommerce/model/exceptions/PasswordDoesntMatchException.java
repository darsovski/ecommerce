package com.springboot.ecommerce.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class PasswordDoesntMatchException extends RuntimeException {
    public PasswordDoesntMatchException() {
        super("Password doesn't match!!!");
    }
}
