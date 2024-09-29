package com.fsd2425.projectback.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2425.projectback.entity.Product;
import com.fsd2425.projectback.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(String id, Product productDetails) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
    	product.setName(productDetails.getName());
    	product.setPrice(productDetails.getPrice());
    	product.setQuantity(productDetails.getQuantity());
    	product.setDescription(productDetails.getDescription());
    	product.setIngredients(productDetails.getIngredients());
    	product.setPhoto(productDetails.getPhoto());
        
        return productRepository.save(product);
    }

    public void deleteUser(String id) {
    	productRepository.deleteById(id);
    }
}
