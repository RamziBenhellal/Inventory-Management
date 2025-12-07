package com.ramzi.inventorymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public class ProductDto {

    private Long id;

    @NotBlank
    private String name;

    private String sku;

    @NotNull
    @Min(0)
    private Integer quantity;

    @NotNull
    @Min(0)
    private Integer minStock;

    private BigDecimal price;

    private String categoryName;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategoryName(String category_name) {
        this.categoryName = category_name;
    }
}
