package com.ramzi.inventorymanagement.service;

import com.ramzi.inventorymanagement.dto.ProductDto;
import com.ramzi.inventorymanagement.entity.Category;
import com.ramzi.inventorymanagement.entity.Product;
import com.ramzi.inventorymanagement.exception.ResourceNotFoundException;
import com.ramzi.inventorymanagement.repository.CategoryRepository;
import com.ramzi.inventorymanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"+ id));
    }

    public Product create(ProductDto dto) {
        Product product = mapToEntity(dto);
        return productRepository.save(product);
    }

    public Product update(ProductDto dto, Long id) {
        Product existing = getById(id);
        existing.setName(dto.getName());
        existing.setSku(dto.getSku());
        existing.setQuantity(dto.getQuantity());
        existing.setMinStock(dto.getMinStock());
        existing.setPrice(dto.getPrice());

        if(dto.getCategoryName() != null) {
            Category category = getOrCreateCategory(dto.getCategoryName());
            existing.setCategory(category);
        }
        return productRepository.save(existing);

    }

    public void delete(Long id) {
        Product product = getById(id);
        productRepository.delete(product);
    }

    public List<Product> getLowStockProduct(){
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() <= p.getMinStock())
                .toList();
    }

    private Product mapToEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setQuantity(dto.getQuantity());
        product.setMinStock(dto.getMinStock());
        product.setPrice(dto.getPrice());

        if(dto.getCategoryName() != null){
            Category category = getOrCreateCategory(dto.getCategoryName());
            product.setCategory(category);
        }
        return product;
    }

    private Category getOrCreateCategory(String categoryName) {
        return categoryRepository.findByNameIgnoreCase(categoryName)
                .orElseGet(()-> categoryRepository.save(new Category(categoryName))) ;
    }
}
