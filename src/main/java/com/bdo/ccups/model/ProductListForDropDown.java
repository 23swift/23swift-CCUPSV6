package com.bdo.ccups.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "forDropDown", types = {Product.class})
public interface ProductListForDropDown {

    // Long getId();
    // String getCode();
    // String getName();
    @Value("#{target.getInstitution().getName()+' - '+target.getName() }")
    String getName();
    
}