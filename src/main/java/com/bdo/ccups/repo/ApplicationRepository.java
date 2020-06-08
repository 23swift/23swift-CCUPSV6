package com.bdo.ccups.repo;

import java.util.Optional;

import com.bdo.ccups.model.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// public interface ApplicationRepository extends CrudRepository<Application,Long>{
@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>{
    // Optional<Application> findById(Long id);
}