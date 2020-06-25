package com.bdo.ccups.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "dropDown", types = {Product.class})
public interface ProductListForDropDown {

    Long getId();
    String getCode();
    String getName();
    
}