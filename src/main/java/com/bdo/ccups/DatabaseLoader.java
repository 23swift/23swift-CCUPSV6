package com.bdo.ccups;

import java.sql.Date;

import com.bdo.ccups.model.Employee;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;
import com.bdo.ccups.repo.EmployeeRepository;
import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final EmployeeRepository repository;
	private final ApplicationRepository appRepo;
	private final ProductRepository productRepo;
	private final InstitutionRepository instRepo;
	@Autowired 
	public DatabaseLoader(EmployeeRepository repository,ApplicationRepository appRepo,ProductRepository productRepo,InstitutionRepository instRepo) {
		this.repository = repository;
		this.appRepo=appRepo;
		this.productRepo=productRepo;
		this.instRepo=instRepo;

	}

	@Override
	public void run(String... strings) throws Exception { 
	Institution inst=	this.instRepo.saveAndFlush(new Institution("SMART", "1000", "0000001"));
	this.instRepo.saveAndFlush(new Institution("MERALCO", "1002", "0000002"));

	 Product prod=	this.productRepo.save(new Product(
			"0001","SMART GOLD"
		));
		this.productRepo.save(new Product(
			"0002","SMART PLATINUM"
		));
		
		this.appRepo.save(new Application("1111111022","Costamero","ARnold",prod,inst,"00001",true,19));
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer",Date.valueOf("2019-01-26")));
	}
}