package com.bdo.ccups.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "applicationWithProduct", types = { Application.class })
public interface ApplicationWithProduct {

    String getCardNumber();
    Product getProduct();
    
    String getSelfLink();
    
}