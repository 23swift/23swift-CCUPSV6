package com.bdo.ccups.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
   
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    

    @Column
    private String name;

    @Column
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
}