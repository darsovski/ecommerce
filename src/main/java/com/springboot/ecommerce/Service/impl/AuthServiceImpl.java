package com.springboot.ecommerce.Service.impl;


import com.springboot.ecommerce.Service.AuthService;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.model.exceptions.InvalidArgumentsException;
import com.springboot.ecommerce.model.exceptions.InvalidUserCredentialsException;
import com.springboot.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
