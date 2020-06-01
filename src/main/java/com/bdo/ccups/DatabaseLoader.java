package com.bdo.ccups;

import java.sql.Date;

import com.bdo.ccups.model.Employee;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;
import com.bdo.ccups.repo.EmployeeRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final EmployeeRepository repository;
	private final ApplicationRepository appRepo;
	private final ProductRepository productRepo;
	@Autowired 
	public DatabaseLoader(EmployeeRepository repository,ApplicationRepository appRepo,ProductRepository productRepo) {
		this.repository = repository;
		this.appRepo=appRepo;
		this.productRepo=productRepo;
	}

	@Override
	public void run(String... strings) throws Exception { 
	 Product prod=	this.productRepo.save(new Product(
			"0001","SMart"
		));
		
		this.appRepo.save(new Application("1111111022","Costamero","ARnold","SMART",prod,"00001",true));
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer",Date.valueOf("2019-01-26")));
	}
}