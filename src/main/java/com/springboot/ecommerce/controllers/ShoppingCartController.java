package com.springboot.ecommerce.controllers;



import com.springboot.ecommerce.Service.AuthService;
import com.springboot.ecommerce.Service.ProductService;
import com.springboot.ecommerce.Service.ShoppingCartService;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.model.ShoppingCart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopping-carts")
@CrossOrigin(origins = "http://localhost:3000")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final AuthService authService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                      AuthService authService,ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.authService = authService;
        this.productService=productService;
    }

    @GetMapping
    public List<ShoppingCart> findAllByUsername(String userName) {
        return this.shoppingCartService.findAllByUsername(userName);
    }

/*    @PostMapping
    public ShoppingCart createNewShoppingCart() {
        return this.shoppingCartService.createNewShoppingCart(this.authService.getCurrentUserId());
    }*/

    @PostMapping("/{productId}/products")
    public ResponseEntity<ShoppingCart> addProductToCart(@PathVariable Long productId) {
        Optional<Product> product = this.productService.findById(productId);

        this.shoppingCartService.addProductToShoppingCart(productId);

        return ResponseEntity.ok().build();

        /*return  this.shoppingCartService.addProductToShoppingCart(productId)
                .(product -> ResponseEntity.ok().body(product))
                .orElseGet(() ->ResponseEntity.badRequest().build());*/
    }

    @DeleteMapping("/{productId}/products")
    public ResponseEntity<ShoppingCart> removeProductFromCart(@PathVariable Long productId) {
        this.shoppingCartService.removeProductFromShoppingCart(productId);
        return ResponseEntity.ok().build();
    }

 /*   @PatchMapping("/cancel")
    public ShoppingCart cancelActiveShoppingCart() {
        return this.shoppingCartService.cancelActiveShoppingCart(this.authService.getCurrentUserId());
    }*/

}
