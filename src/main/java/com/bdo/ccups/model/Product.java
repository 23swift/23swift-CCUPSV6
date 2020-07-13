package com.bdo.ccups.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Product {
    public Product(){

    }
    public Product(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public Product(String code, String name,Institution institution){
		this.code = code;
		this.name = name;
		this.institution=institution;
    }
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String code;
    private String name;

    // @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true  )
	// private List<Application> applications= new ArrayList<>();
	@ManyToOne
	private Institution institution;

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

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
    
}