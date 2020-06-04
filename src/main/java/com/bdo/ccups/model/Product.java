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
    public Product(String code, String name) {
		this.code = code;
		this.name = name;
    }
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String code;
    private String name;

    // @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true  )
    // private List<Application> applications= new ArrayList<>();

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    
}