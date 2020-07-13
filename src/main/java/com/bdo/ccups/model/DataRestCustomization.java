package com.bdo.ccups.model;

import com.bdo.ccups.model.Product;
import com.bdo.ccups.repo.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import org.springframework.stereotype.Component;

@Component
public class DataRestCustomization implements RepositoryRestConfigurer {

 

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        // TODO Auto-generated method stub

        //  config.withEntityLookup().forRepository(ProductRepository.class,Product::getCode,
        // ProductRepository::findByCode);

        // config.setResourceMappingForRepository(ProductRepository.class).addResourceMappings(
           
        // )
        
        // config.setResourceMappingForDomainType(Product.class).addResourceMappings(Map<"ID",>)
        // config.exposeIdsFor(Product.class);
        // RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
        // config.withEntityLookup().forValueRepository(ProductRepository.class, config.getResourceMappingForDomainType(Product.class
        // ).getPath(), ProductRepository::findById);
        // config.getResourceMappingForDomainType(Application.class).addResourceMappingFor("links").
        // config.setRelProvider(relProvider);
    }
    
}