package com.bdo.ccups.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.RestResource;



// "id":2,"card_number":"3555484527646565","last_name":"Shevelin","first_name":"Kimberley","institution":"Izio","product":"jcb","reference_no":"1987320255","merchant":false
@Entity

public class Application{
   public Application(){}
    
   
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	// @RestResource(description = @Description("BDO Card Number")) 
	private String cardNumber;
	
    private String lastName;
	private String firstName;
	private String middleName;
	private boolean forApproval;
	private String status="";
	
	@ManyToOne 
	// @RestResource(rel = "application_product")
	// @RestResource(exported = false)
	private Product product;

	// @ManyToOne  
	// private Institution institution;
	
	private String referenceNo;
	private boolean merchant;
	private int cardProduct;

	public Application(String cardNumber, String lastName, String firstName, String middleName, Product product,
			// Institution institution, 
			String referenceNo, boolean merchant, int cardProduct) {
		this.cardNumber = cardNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.product = product;
		// this.institution = institution;
		this.referenceNo = referenceNo;
		this.merchant = merchant;
		this.cardProduct = cardProduct;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// public Institution getInstitution() {
	// 	return institution;
	// }

	// public void setInstitution(Institution institution) {
	// 	this.institution = institution;
	// }

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public boolean isMerchant() {
		return merchant;
	}

	public void setMerchant(boolean merchant) {
		this.merchant = merchant;
	}

	public int getCardProduct() {
		return cardProduct;
	}

	public void setCardProduct(int cardProduct) {
		this.cardProduct = cardProduct;
	}

	public boolean isForApproval() {
		return forApproval;
	}

	public void setForApproval(boolean forApproval) {
		this.forApproval = forApproval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}