package com.springboot.ecommerce.controllers;

import com.springboot.ecommerce.Service.UserService;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<User> listAllUsers() {  return this.userService.findAll(); }


    @GetMapping(value = "/{username}")
    public ResponseEntity<User> findByUserName(@PathVariable String username) {
             this.userService.findByUserName(username);
             return ResponseEntity.ok().build();
    }


    @PostMapping(value = "/add")
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        return  this.userService.save(userDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
             this.userService.deleteById(id);
             return ResponseEntity.ok().build();
    }
}
