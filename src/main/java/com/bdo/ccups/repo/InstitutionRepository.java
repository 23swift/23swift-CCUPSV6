package com.bdo.ccups.repo;

import com.bdo.ccups.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.data.repository.CrudRepository;


// @CrossOrigin(origins = "http://localhost:3000")
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
} 
