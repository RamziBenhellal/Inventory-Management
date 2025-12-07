package com.ramzi.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ramzi.inventorymanagement.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNameContainingIgnoreCase(String name);

}
