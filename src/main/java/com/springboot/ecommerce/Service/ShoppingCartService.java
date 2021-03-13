package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {
    ShoppingCart findActiveShoppingCartByUsername(Long userId);
    List<ShoppingCart> findAllByUsername(String userName);
    ShoppingCart createNewShoppingCart(Long userId);
    ShoppingCart addProductToShoppingCart(Long userId, Long productId);
    ShoppingCart addProductToShoppingCart(Long productId);
    ShoppingCart removeProductFromShoppingCart(Long userId, Long productId);
    ShoppingCart removeProductFromShoppingCart(Long productId);
    ShoppingCart getActiveShoppingCart(Long userId);
    ShoppingCart cancelActiveShoppingCart(Long userId);
}
