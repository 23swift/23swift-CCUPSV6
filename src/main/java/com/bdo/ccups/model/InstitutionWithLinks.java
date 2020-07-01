package com.bdo.ccups.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * InstitutionWithLinks
 */
@Projection(name = "withLinks", types = { Institution.class })
public interface InstitutionWithLinks {
    Long getId();
    String getName();
    
}