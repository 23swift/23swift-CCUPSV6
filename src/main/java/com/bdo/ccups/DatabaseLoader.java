package com.bdo.ccups;

import java.sql.Date;
import java.util.ArrayList;

import com.bdo.ccups.model.Employee;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.*;
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
		Product prod1=	this.productRepo.save(new Product(
			"0001","SMART GOLD"
		));
		Product prod2=this.productRepo.save(new Product(
			"0002","SMART PLATINUM"
		));
		ArrayList<Product> prodList=new ArrayList<Product>();
		prodList.add(prod1);
		prodList.add(prod2);


	this.instRepo.saveAndFlush(new Institution("MERALCO", "1002", "0000002"));
	this.instRepo.saveAndFlush(new Institution("GLOBE Telecoms", "1003", "0000003"));
	this.instRepo.saveAndFlush(new Institution("PLDT", "1004", "0000004"));

	
		
		
		
	}
}