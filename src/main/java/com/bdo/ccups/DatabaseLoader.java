package com.bdo.ccups;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.model.Role;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.*;

import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component 
public class DatabaseLoader implements CommandLineRunner { 

	
	private final ApplicationRepository appRepo;
	private final ProductRepository productRepo;
	private final InstitutionRepository instRepo;
	
    private final UserRepository userRepo;


	@Autowired 
	public DatabaseLoader(ApplicationRepository appRepo,ProductRepository productRepo,InstitutionRepository instRepo,UserRepository userRepo) {
		
		this.appRepo=appRepo;
		this.productRepo=productRepo;
		this.instRepo=instRepo;
		this.userRepo=userRepo;
		
	}

	@Override
	public void run(String... strings) throws Exception { 
		
		List <Role> roles= new ArrayList<Role>();
		// roles.add(new Role("ROLE_USER","ROLE_USER" ));
		roles.add(new Role("ROLE_APPROVER","ROLE_APPROVER" ));

		this.userRepo.save(new  com.bdo.ccups.model.User( "a012001164","password","arnold", roles));

		Institution inst=	this.instRepo.save(new Institution("SMART Communications", "1000", "0000001"));
		ArrayList<Product> prodList=new ArrayList<Product>();
		Product prod1=	this.productRepo.save(new Product(
			"0001","SMART GOLD",inst
		));
		Product prod2=this.productRepo.save(new Product( 
			"0002","SMART PLATINUM",inst
		));

		prodList.add(prod1);
		prodList.add(prod2);



	this.instRepo.save(new Institution("MERALCO", "1002", "0000002"));
	this.instRepo.save(new Institution("GLOBE Telecoms", "1003", "0000003"));
	this.instRepo.save(new Institution("PLDT", "1004", "0000004"));

	
		
		// this.appRepo.save(new Application("1111111022111111","Costamero","ARnold","Belen",prod2,"00001",true,19));
		// this.appRepo.save(new Application("1111111022111112","Costamero","ARnold2","Belen",prod1,"00002",true,19));
		
	}
}