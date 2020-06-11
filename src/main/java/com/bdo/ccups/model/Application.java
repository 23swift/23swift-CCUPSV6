package com.bdo.ccups.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// "id":2,"card_number":"3555484527646565","last_name":"Shevelin","first_name":"Kimberley","institution":"Izio","product":"jcb","reference_no":"1987320255","merchant":false
@Entity
public class Application {
   public Application(){}
    
   public Application(String card_number, String last_name, String first_name, String middle_name, Product product,
   Institution institution, String reference_no, boolean merchant, int card_product) {
	this.card_number = card_number;
	this.last_name = last_name;
	this.first_name = first_name;
	this.middle_name = middle_name;
	this.product = product;
	this.institution = institution;
	this.reference_no = reference_no;
	this.merchant = merchant;
	this.card_product = card_product;
	}

  




	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String card_number;
    private String last_name;
	private String first_name;
	private String middle_name;
	
	@ManyToOne (fetch=FetchType.EAGER)
	private Product product;
	@ManyToOne (fetch=FetchType.EAGER)
	private Institution institution;
	
	private String reference_no;
	private boolean merchant;
	private int card_product;
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public boolean isMerchant() {
		return merchant;
	}

	public void setMerchant(boolean merchant) {
		this.merchant = merchant;
	}

	public String getCard_number() {
		return card_number;
	}
	
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}







	public Product getProduct() {
		return product;
	}







	public void setProduct(Product product) {
		this.product = product;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public int getCard_product() {
		return card_product;
	}

	public void setCard_product(int card_product) {
		this.card_product = card_product;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

}