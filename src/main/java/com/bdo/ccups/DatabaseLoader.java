package com.bdo.ccups;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.model.Role;
import com.bdo.ccups.model.User;
import com.bdo.ccups.helpers.RoleValue;
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
	private final RoleRepository roleRepository;

	@Autowired 
	public DatabaseLoader(ApplicationRepository appRepo,ProductRepository productRepo,InstitutionRepository instRepo,UserRepository userRepo,RoleRepository roleRepository) {
		
		this.appRepo=appRepo;
		this.productRepo=productRepo;
		this.instRepo=instRepo;
		this.userRepo=userRepo;
		this.roleRepository=roleRepository;
		
	}

	@Override
	public void run(String... strings) throws Exception { 
		
		Role role_user =this.roleRepository.save(new Role(RoleValue.ROLE_USER,RoleValue.ROLE_USER ));
		Role role_admin =this.roleRepository.save(new Role(RoleValue.ROLE_ADMIN,RoleValue.ROLE_ADMIN) );
		Role role_requestor =this.roleRepository.save(new Role(RoleValue.ROLE_REQUESTOR,RoleValue.ROLE_REQUESTOR ) );
		Role role_approver =this.roleRepository.save(new Role(RoleValue.ROLE_APPROVER,RoleValue.ROLE_APPROVER ));

		List <Role> roles1= new ArrayList<Role>();
		roles1.add(role_user);
		roles1.add(role_requestor);
		// roles1.add(new Role("ROLE_APPROVER","ROLE_APPROVER" ));
		List <Role> roles2= new ArrayList<Role>();
		roles2.add(role_user);
		// roles2.add(new Role("ROLE_REQUESTOR","ROLE_REQUESTOR" ));
		roles2.add(role_approver);

		User user_requestor =this.userRepo.save(new  com.bdo.ccups.model.User( "requestor","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6","arnold", null));
		user_requestor.setRoles(roles1);
		this.userRepo.save(user_requestor);
		User user_approver=this.userRepo.save(new  com.bdo.ccups.model.User( "approver","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6","arnold", null));
		user_approver.setRoles(roles2);
		this.userRepo.save( user_approver);

		List <Role> roles3= new ArrayList<Role>();
		roles3.add(role_user);
		// roles3.add(new Role("ROLE_REQUESTOR","ROLE_REQUESTOR" ));
		roles3.add(role_admin);
		User user_admin=this.userRepo.save(new  com.bdo.ccups.model.User( "admin","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6","arnold", null));
		user_admin.setRoles(roles3);
		this.userRepo.save( user_admin);

		// Institution inst=	this.instRepo.save(new Institution("SMART Communications", "1000", "0000001"));
		// ArrayList<Product> prodList=new ArrayList<Product>();
		// Product prod1=	this.productRepo.save(new Product(
		// 	"0001","SMART GOLD",inst
		// ));
		// Product prod2=this.productRepo.save(new Product( 
		// 	"0002","SMART PLATINUM",inst
		// ));

		// prodList.add(prod1);
		// prodList.add(prod2);


	this.instRepo.save(new Institution("SMART Communications", "1000", "0000001"));
	this.instRepo.save(new Institution("MERALCO", "1002", "0000002"));
	this.instRepo.save(new Institution("GLOBE Telecoms", "1003", "0000003"));
	this.instRepo.save(new Institution("PLDT", "1004", "0000004"));

	
		
		// this.appRepo.save(new Application("1111111022111111","Costamero","ARnold","Belen",prod2,"00001",true,19));
		// this.appRepo.save(new Application("1111111022111112","Costamero","ARnold2","Belen",prod1,"00002",true,19));
		
	}
}