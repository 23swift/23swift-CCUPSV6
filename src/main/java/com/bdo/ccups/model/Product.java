package com.bdo.ccups.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Product {
    public Product(){

    }
    public Product(String code, String description) {
		this.code = code;
		this.description = description;
    }
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String code;
    private String description;

    // @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true  )
    // private List<Application> applications= new ArrayList<>();

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    
}