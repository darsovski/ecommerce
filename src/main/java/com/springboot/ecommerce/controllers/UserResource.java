package com.springboot.ecommerce.controllers;/*
package com.devrobot.springbootecommerce.controllers;

import com.devrobot.springbootecommerce.model.User;
import com.devrobot.springbootecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/{username}")
	public User get(@PathVariable("username") String username) {
		return userRepository.findById(username).get();
	}

	@PostMapping(value = "/add")
	public User persist(@RequestBody final User user) {
		userRepository.save(user);
		return userRepository.findById(user.getUsername()).get(); 
	}

	@DeleteMapping(value = "/delete")
	public List<User> delete(@PathVariable String username) {
		userRepository.deleteById(username);
		return userRepository.findAll();
	}

	@PutMapping(value = "/{username}/put")
	public List<User> put(@PathVariable String username, @RequestBody User user) {
		if (userRepository.existsById(username)) {
			userRepository.deleteById(username);
			userRepository.save(user);
		}
		
		return userRepository.findAll();
	}
}
*/
