package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService  {
   // Optional<User> findByUserName(String userName);
    User registerUser(User user);
    User findByUserName(String userName);
    User findById(Long userId);
    List<User> findAll();
    Optional<User> save(String firstName, String lastName, String username, String email, String password, boolean isAdmin);
    Optional<User> save(UserDto userDto);
    void deleteById(Long id);

}
