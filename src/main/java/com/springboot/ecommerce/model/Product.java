package com.springboot.ecommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Product  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String description;

	private Integer quantity;

	private Double weight;

	private Double price;

/*	@ManyToOne
	@JsonBackReference
	private Category category;*/

	public Product() {
	}

	public Product( String name, String description,Integer quantity, Double weight, Double price/*, Category category*/) {
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.price = price;
		//this.category =  category;
	}

}
