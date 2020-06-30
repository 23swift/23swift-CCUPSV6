package com.bdo.ccups.repo;

import com.bdo.ccups.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { 

}