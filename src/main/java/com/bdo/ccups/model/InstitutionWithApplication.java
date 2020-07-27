package com.bdo.ccups.model;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.security.access.prepost.PreAuthorize;

// @PreAuthorize( "hasRole('ROLE_USER')")
@Projection(name = "withApplication", types = { Institution.class })
public interface InstitutionWithApplication {
    String getName();
    String getCode();
    String getMerchantId();
    // List<Application> getApplications();
    
}