package com.springboot.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String password;

	private boolean isAdmin;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	public User() {
	}
	public User(String firstName,String lastName, String username, String email, String password, boolean isAdmin) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

}
