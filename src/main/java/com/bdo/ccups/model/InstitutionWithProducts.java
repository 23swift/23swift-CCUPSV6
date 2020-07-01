package com.bdo.ccups.model;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withProducts", types = { Institution.class })
public interface InstitutionWithProducts {
    Long getId();
    String getName();
    // List<Product> getProducts();
    
}