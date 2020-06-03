package com.bdo.ccups.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bdo.ccups.model.DropDown;
import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dd")
public class DropDownController {

    @Autowired
    private  ProductRepository productRepo;

    @Autowired
    private InstitutionRepository institutionRepo;

    @GetMapping("products")
    public List<Product> getProducts(){
        List<Product> result = this.productRepo.findAll();
        
        return result;
          
    }
    @GetMapping("institutions")
    public List<Institution> getInstitution(){
        List<Institution> result = this.institutionRepo.findAll();
        
        return result;
          
    }
    
}