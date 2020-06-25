package com.bdo.ccups.model;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.model.Institution;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "applicationWithInstitution", types = { Application.class })
public interface ApplicationProjection {

    String  getFirst_name();
    String getLast_name();
    String getReference_no();
    String getCardNumber();
    // Product getProduct();
     Institution getInstitution();
    
}