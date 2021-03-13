package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService   {
  /*  User getCurrentUser();
    String getCurrentUserId();
    User signUpUser(String username, String password, String repeatedPassword);*/
    User login(String username, String password);
}
