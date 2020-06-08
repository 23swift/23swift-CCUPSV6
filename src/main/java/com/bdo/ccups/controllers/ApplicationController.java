package com.bdo.ccups.controllers;


import java.util.List;

import com.bdo.ccups.ExceptionHandlers.EntityNotFoundException;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
 public Application GetApplications(@RequestBody Application newApplication) throws Exception {
   
    // appRepo.saveAndFlush(newApplication);
    
         return appRepo.saveAndFlush(newApplication);
    
       
    
}
    
}