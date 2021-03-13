package com.springboot.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="roles")
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
}
