package com.bdo.ccups.model;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withApplication", types = { Institution.class })
public interface InstitutionProjection {
    String getName();
    String getCode();
    String getMerchantId();
    // List<Application> getApplications();
    
}