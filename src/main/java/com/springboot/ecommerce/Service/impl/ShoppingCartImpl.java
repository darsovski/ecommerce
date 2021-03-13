package com.springboot.ecommerce.Service.impl;


import com.springboot.ecommerce.Service.PaymentService;
import com.springboot.ecommerce.Service.ProductService;
import com.springboot.ecommerce.Service.ShoppingCartService;
import com.springboot.ecommerce.Service.UserService;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.model.ShoppingCart;
import com.springboot.ecommerce.model.ShoppingCartStatus;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.model.exceptions.*;
import com.springboot.ecommerce.repository.ShoppingCartRepository;
import com.stripe.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    private final UserService userService;
    private final ProductService productService;
    private final PaymentService paymentService;

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartImpl(UserService userService,
                                   ProductService productService,
                                   PaymentService paymentService,
                                   ShoppingCartRepository shoppingCartRepository) {
        this.userService = userService;
        this.productService = productService;
        this.paymentService = paymentService;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public ShoppingCart findActiveShoppingCartByUsername(Long userId) {
        return this.shoppingCartRepository.findByIdAndStatus(userId, ShoppingCartStatus.CREATED)
                .orElseThrow(() -> new ShoppingCartIsNotActiveException(userId));
    }

    @Override
    public List<ShoppingCart> findAllByUsername(String userName) {
        return this.shoppingCartRepository.findAllByUser(userName);
    }


    @Override
    public ShoppingCart createNewShoppingCart(Long userId) {
        User user = this.userService.findById(userId);
        if (this.shoppingCartRepository.existsByUserUsernameAndStatus(
                user.getUsername(),
                ShoppingCartStatus.CREATED
        )) {
            throw new ShoppingCartIsAlreadyCreated(userId);
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        return this.shoppingCartRepository.save(shoppingCart);
    }



    @Override
    public ShoppingCart addProductToShoppingCart(Long userId, Long productId) {
        Optional<Product> product = this.productService.findById(productId);
        ShoppingCart shoppingCart = this.getActiveShoppingCart(userId);
        for (Product productTerm : shoppingCart.getProducts()) {
            if (productTerm.getId().equals(productId)) {
                throw new ProductIsAlreadyInShoppingCartException(productTerm.getName());
            }
        }
         shoppingCart.getProducts().add(product.orElseThrow(()-> new ProductNotFoundException(productId)));
        return shoppingCart;
    }

    @Override
    public ShoppingCart addProductToShoppingCart(Long productId) {
        Optional<Product> product = this.productService.findById(productId);
        ShoppingCart shoppingCart=this.shoppingCartRepository.findByUser(product.get().getName())
                .orElseThrow(() -> new ShoppingCartNotFoundException());
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart.getProducts().add(product.orElseThrow(() -> new ProductNotFoundException(productId)));
        return shoppingCart1;
    }


    @Override
    @Transactional
    public ShoppingCart removeProductFromShoppingCart(Long userId, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(userId);
        shoppingCart.setProducts(
                shoppingCart.getProducts()
                        .stream()
                        .filter(product -> !product.getId().equals(productId))
                        .collect(Collectors.toList())
        );
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeProductFromShoppingCart(Long productId) {
            ShoppingCart shoppingCart=new ShoppingCart();
            shoppingCart.setProducts(
                    shoppingCart.getProducts()
                    .stream()
                    .filter(product -> !product.getId().equals(productId))
                    .collect(Collectors.toList())
            );
            return this.shoppingCartRepository.save(shoppingCart);
    }


    @Override
    public ShoppingCart getActiveShoppingCart(Long userId) {
        return this.shoppingCartRepository
                .findByIdAndStatus(userId, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart shoppingCart = new ShoppingCart();
                    User user = this.userService.findById(userId);
                    shoppingCart.setUser(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart cancelActiveShoppingCart(Long userId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository
                .findByIdAndStatus(userId, ShoppingCartStatus.CREATED)
                .orElseThrow(() -> new ShoppingCartIsNotActiveException(userId));
        shoppingCart.setStatus(ShoppingCartStatus.CANCELED);
        return this.shoppingCartRepository.save(shoppingCart);
    }

}
