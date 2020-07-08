package com.bdo.ccups.model;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.model.Institution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;



@Projection(name = "applicationWithInstitution", types = { Application.class })
public interface ApplicationWithInstitution {
    Long getId();
    // String  getFirst_name();
    // String getLast_name();
    @Value("#{target.getFirstName() + ' ' + target.getLastName()}")
    String getName();
    String getReferenceNo();
    String getCardNumber();

    @Value("#{target.getProduct().getName()}")
    String getProduct();

    // Product getProduct();

    @Value("#{target.getProduct().getInstitution().getName()}")
    String getInstitutionName();

   
}