package com.bdo.ccups;

import javax.annotation.PostConstruct;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.repo.ApplicationRepository;
import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication


public class CcupsApplication  {
	@Value("${front_end.origin}")
	String fornt_end_origin;

	@Autowired 
	private  ApplicationRepository appRepo;
	@Autowired 
	private  ProductRepository productRepo;
	
	@Autowired 
	private  InstitutionRepository instRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CcupsApplication.class, args);
	}
	public @PostConstruct void init() {

		Institution inst=	this.instRepo.save(new Institution("SMART Communications", "1000", "0000001"));

	Product prod1=	this.productRepo.save(new Product(
			"0001","SMART GOLD",inst
		));
		Product prod2=this.productRepo.save(new Product( 
			"0002","SMART PLATINUM",inst
		));

	this.instRepo.save(new Institution("MERALCO", "1002", "0000002"));
	this.instRepo.save(new Institution("GLOBE Telecoms", "1003", "0000003"));
	this.instRepo.save(new Institution("PLDT", "1004", "0000004"));

	
		
		this.appRepo.save(new Application("1111111022111111","Costamero","ARnold","Belen",prod2,"00001",true,19));
		this.appRepo.save(new Application("1111111022111112","Costamero","ARnold2","Belen",prod1,"00002",true,19));
		
	}
	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/**").allowedMethods("POST","PUT","GET").allowedOrigins(fornt_end_origin);
	// 		}
			
	// 	};
	// }
	// @Bean
	// public WebMvcConfigurer basePathConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 			public void configurePathMatch(PathMatchConfigurer configurer) {
	// 				configurer.addPathPrefix("api", HandlerTypePredicate.forAnnotation(RepositoryRestController.class));
	// 			}
			
	// 	};
	// }

	// @Bean
	// public WebSecurityConfigurerAdapter userConfigurer() {
	// 	return new WebSecurityConfigurerAdapter() {
		
	// 		@Override
	// 		public void configure(AuthenticationManagerBuilder auth) throws Exception {

	// 			auth.inMemoryAuthentication()
	// 			.withUser("a012001164").password("{noop}password").roles("USER").and()
	// 			.withUser("ollie").password("{noop}gierke").roles("USER", "ADMIN");
	// 		}

	// 		// @Override
	// 		// 	protected void configure(HttpSecurity http) throws Exception {

	// 		// 		http
	// 		// 		.httpBasic().and()
	// 		// 		.authorizeRequests()
	// 		// 			.antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
	// 		// 			.antMatchers(HttpMethod.PUT, "/api/applications/actions/**").hasRole("ADMIN").and()
						
						
	// 		// 		.csrf().disable();
	// 		// 	}
	// 	};
	// }

	
}
