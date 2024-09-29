package com.fsd2425.projectback.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.fsd2425.projectback.entity.Product;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByName(String name);
}
