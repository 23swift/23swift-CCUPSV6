package com.bdo.ccups.repo;

import java.util.List;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product,Long> {
// public interface ProductRepository extends CrudRepository<Product,Long> {
// public interface ProductRepository extends JpaRepository<Product,Long> {

   List<Product> findByInstitutionId(@Param("id") Long id);
    Product findByCode(String code);
}