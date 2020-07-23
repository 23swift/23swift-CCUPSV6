package com.bdo.ccups.repo;

import java.util.List;
import java.util.Optional;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


//  @PreAuthorize( "hasAnyRole('ROLE_USER','ROLE_APPROVER')")
 @PostAuthorize( "hasAnyRole('ROLE_USER','ROLE_APPROVER')")
public interface ApplicationRepository extends CrudRepository<Application,Long>{
   
// public interface ApplicationRepository extends JpaRepository<Application,Long>{
// @RepositoryRestResource()
// List<Application> findAllByInstitutionName(@Param("name") String name);
    
    
}