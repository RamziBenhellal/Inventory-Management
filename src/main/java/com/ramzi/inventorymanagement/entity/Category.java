package com.ramzi.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data


public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;



}
