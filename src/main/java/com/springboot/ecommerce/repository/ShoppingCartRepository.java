package com.springboot.ecommerce.repository;


import com.springboot.ecommerce.model.ShoppingCart;
import com.springboot.ecommerce.model.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
        Optional<ShoppingCart> findByUser(String user);
        Optional<ShoppingCart> findByDateCreated(LocalDateTime localDateTime);
        Optional<ShoppingCart> findByIdAndStatus(Long userid, ShoppingCartStatus status);
        boolean existsByUserUsernameAndStatus(String username, ShoppingCartStatus status);
        List<ShoppingCart> findAllByUser(String username);

}
