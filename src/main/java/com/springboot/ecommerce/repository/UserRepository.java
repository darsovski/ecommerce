package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
        Optional<User> findByUsernameAndPassword(String username, String password);
        Optional<User> findByUsername(String username);
        Optional<User> findById(Long userId);
        void deleteByUsername(String name);
        void deleteById(Long id);

}
