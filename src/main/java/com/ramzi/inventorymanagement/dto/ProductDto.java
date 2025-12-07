package com.ramzi.inventorymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotBlank
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

    private String category_name;



}
