package com.bdo.ccups.controllers;


import java.util.List;
import java.util.Optional;

import com.bdo.ccups.ExceptionHandlers.EntityNotFoundException;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
//  @RequestMapping("api")
public class ApplicationController {
@Autowired
ApplicationRepository appRepo;
// 
@GetMapping("applications")
 public List<Application> GetApplications() {
     
     return appRepo.findAll();
 }
 @GetMapping("applications/{id}")
 public Application GetApplicationById(@PathVariable("id") Long id) throws EntityNotFoundException {
     
     return appRepo.findById(id).orElseThrow(()->new EntityNotFoundException(Application.class, "id", id.toString()));
    //  orElse(throw new EntityNotFoundException(Application.class, "id", id.toString());
 }

 @ResponseStatus(code = HttpStatus.CREATED)
 @PostMapping("applications")
 public Application SaveApplications(@RequestBody Application newApplication) throws Exception {
   
    // appRepo.saveAndFlush(newApplication);
    
         return appRepo.saveAndFlush(newApplication);
    
       
    
}

@ResponseStatus(code = HttpStatus.OK)
@PutMapping("applications")
public ResponseEntity<Application> UpdateApplications(@RequestBody Application newApplication) throws Exception {
  
      
        Optional<Application> currentApplication=   appRepo.findById(newApplication.getId());
        if(currentApplication.isPresent()){
         Application _currentApplication=currentApplication.get();
            _currentApplication.setCard_number(newApplication.getCard_number());
            _currentApplication.setFirst_name(newApplication.getFirst_name());
            _currentApplication.setLast_name(newApplication.getLast_name());
            _currentApplication.setCard_product(newApplication.getCard_product());
            _currentApplication.setProduct(newApplication.getProduct());
            _currentApplication.setReference_no(newApplication.getReference_no());
            _currentApplication.setInstitution(newApplication.getInstitution());
            _currentApplication.setMerchant(newApplication.isMerchant());
            return new ResponseEntity<>(appRepo.save(_currentApplication), HttpStatus.OK);
        } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
      

        
   
      
   
}
    
}