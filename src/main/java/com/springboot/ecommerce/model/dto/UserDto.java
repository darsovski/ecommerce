package com.springboot.ecommerce.model.dto;


import lombok.Data;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private boolean isAdmin;

    public UserDto(String firstName, String lastName, String username, String email, String password, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
