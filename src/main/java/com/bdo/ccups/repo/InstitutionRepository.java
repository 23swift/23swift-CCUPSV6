package com.bdo.ccups.repo;

import com.bdo.ccups.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface InstitutionRepository extends JpaRepository<Institution,Integer> {}
// public interface InstitutionRepository extends CrudRepository<Institution,Integer> {} 
