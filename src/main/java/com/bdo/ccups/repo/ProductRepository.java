package com.bdo.ccups.repo;

import com.bdo.ccups.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
    
}