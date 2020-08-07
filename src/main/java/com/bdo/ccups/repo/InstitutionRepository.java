package com.bdo.ccups.repo;

import java.util.Collection;
import java.util.List;

import com.bdo.ccups.helpers.RoleValue;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;


// @CrossOrigin(origins = "http://localhost:3000")
// @PostAuthorize( RoleValue.PostAuthorize_ROLE_USER)
public interface InstitutionRepository extends CrudRepository<Institution,Long> {


   
    @Query("select inst from Institution inst")
    // @PostAuthorize( RoleValue.PostAuthorize_ROLE_ADMIN)
    Collection<Institution> findAllInstitutionsForMaintenace();
} 
