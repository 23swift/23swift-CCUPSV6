package com.bdo.ccups.model;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.rest.core.config.Projection;




@Projection(name = "applicationWithInstitution", types = { Application.class })
public interface ApplicationWithInstitution {
    Long getId();
    // String  getFirstName();
    String getLastName();
    @Value("#{target.getFirstName() + ' ' + target.getLastName()}")
    String getName();
    String getReferenceNo();
    String getCardNumber();

    @Value("#{target.getProduct().getName()}")
    String getProduct();

    // Product getProduct();

    @Value("#{target.getProduct().getInstitution().getName()}")
    String getInstitutionName();
    String getStatus();
    
}