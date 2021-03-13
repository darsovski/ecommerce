package com.springboot.ecommerce.controllers;

import com.springboot.ecommerce.Service.ProductService;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.model.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsRestController {

	private final ProductService productService;

	public ProductsRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/all")
	public List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
			return this.productService.findById(id)
					.map(product -> ResponseEntity.ok().body(product))
					.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
			return  this.productService.save(productDto)
					.map(product -> ResponseEntity.ok().body(product))
					.orElseGet(() -> ResponseEntity.badRequest().build());
	}


	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<Product> save(@PathVariable Long id, @RequestBody ProductDto productDto) {
		return  this.productService.edit(id,productDto)
				.map(product -> ResponseEntity.ok().body(product))
				.orElseGet(() -> ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable Long id) {
			this.productService.deleteById(id);
			return ResponseEntity.ok().build();
	}

}
