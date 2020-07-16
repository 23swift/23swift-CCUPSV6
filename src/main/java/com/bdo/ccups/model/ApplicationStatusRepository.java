package com.bdo.ccups.model;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationStatusRepository extends CrudRepository<ApplicationStatus,Long> {
    
    ApplicationStatus findByName(String status);
}