package com.bdo.ccups.repo;
import com.bdo.ccups.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

// @PostAuthorize( "hasRole('ROLE_ADMIN')")
public interface RoleRepository extends CrudRepository<Role,Long> {
    
}