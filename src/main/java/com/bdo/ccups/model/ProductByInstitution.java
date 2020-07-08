package com.bdo.ccups.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "byInstitution", types = {Product.class})
public interface ProductByInstitution {
  
    // @Value("#{target.getInstitution().getId()}")
    // Long getInstitutionId();
   

}