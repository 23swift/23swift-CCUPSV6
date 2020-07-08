package com.bdo.ccups.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Institution {
    
    public Institution() {
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String merchantId;

    @OneToMany
    private List<Product> products;
    // private String header;
    
    // @OneToMany(
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // private List<Transaction> transaction=new ArrayList<Transaction>();

    // @OneToMany(
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // private List<FileRow> fileRow=new ArrayList<FileRow>();

    public String getName() {
        return name;
    }

    public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution(String name, String code, String merchantId, List<Product> products) {
        this.name = name;
        this.code = code;
        this.merchantId = merchantId;
        this.products = products;
    }
    public Institution(String name, String code, String merchantId) {
        this.name = name;
        this.code = code;
        this.merchantId = merchantId;
        
    }
    // public String getHeader() {
    //     return header;
    // }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // public void setHeader(String header) {
    //     this.header = header;
    // }

    // public List<Transaction> getTransaction() {
    //     return transaction;
    // }

    // public void setTransaction(List<Transaction> transaction) {
    //     this.transaction = transaction;
    // }

    // public List<FileRow> getFileRow() {
    //     return fileRow;
    // }

    // public void setFileRow(List<FileRow> fileRow) {
    //     this.fileRow = fileRow;
    // }

}