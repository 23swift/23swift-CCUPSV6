package com.bdo.ccups.repo;

import com.bdo.ccups.model.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// public interface ApplicationRepository extends CrudRepository<Application,Long>{
    public interface ApplicationRepository extends JpaRepository<Application,Long>{
    
}