package com.bdo.ccups.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

// @Projection(name = "forDropDown", types = {Product.class})
public interface ProductByInstitution {
  
    @Value("#{target.getInstitution().getName()+' - '+target.getName() }")
    String getProductName();
   

}