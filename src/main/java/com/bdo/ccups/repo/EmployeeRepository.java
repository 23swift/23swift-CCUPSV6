package com.bdo.ccups.repo;

import com.bdo.ccups.model.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> { 

}