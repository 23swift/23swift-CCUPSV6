package com.bdo.ccups;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication

public class CcupsApplication {
	@Value("${front_end.origin}")
    String fornt_end_origin;
	public static void main(String[] args) {
		SpringApplication.run(CcupsApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("POST","PUT","GET").allowedOrigins(fornt_end_origin);
			}
			
		};
	}
	@Bean
	public WebMvcConfigurer basePathConfigurer() {
		return new WebMvcConfigurer() {
			@Override
				public void configurePathMatch(PathMatchConfigurer configurer) {
					configurer.addPathPrefix("api", HandlerTypePredicate.forAnnotation(RepositoryRestController.class));
				}
			
		};
	}


}
