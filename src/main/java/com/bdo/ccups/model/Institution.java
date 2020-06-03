package com.bdo.ccups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Institution {
    public Institution(String name, String code, String merchant_id) {
        this.name = name;
        this.code = code;
        this.merchant_id = merchant_id;
    }

    public Institution() {
    }
    

    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String code;
    private String merchant_id;

    public String getName() {
        return name;
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

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

   
}