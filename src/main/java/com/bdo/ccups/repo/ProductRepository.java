package com.bdo.ccups.repo;

import com.bdo.ccups.model.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    
}