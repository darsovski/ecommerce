package com.springboot.ecommerce.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super(String.format("User with username: %s was not fount!", username));

    }
}
