package com.fsd2425.projectback.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fsd2425.projectback.entity.Product;
import com.fsd2425.projectback.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService userService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("Received Products: " + product);
        Product savedProduct = userService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }


    @GetMapping
    public List<Product> getAllProduct() {
        return userService.getAllProduct();
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getUserById(@PathVariable String id) {
        return userService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product productDetails) {
    	Product updatedProduct = userService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("deleteprod/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
