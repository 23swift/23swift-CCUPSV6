package com.bdo.ccups.repo;

import java.util.Collection;
import java.util.List;

import com.bdo.ccups.helpers.RoleValue;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;

@PostAuthorize( RoleValue.PostAuthorize_ROLE_USER)
public interface ProductRepository extends CrudRepository<Product,Long> {

    // @PostAuthorize( RoleValue.PostAuthorize_ROLE_ADMIN)
   List<Product> findByInstitutionId(@Param("id") Long id);
   Product findByCode(String code);

   @PostAuthorize( RoleValue.PostAuthorize_ROLE_ADMIN)
    @Query("select prod from Product prod")
    Collection<Product> findAllProductsForMaintenance();
}