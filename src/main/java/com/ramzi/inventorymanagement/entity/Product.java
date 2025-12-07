package com.ramzi.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    @Column(unique = true)
    private String sku;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Integer minStock;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
