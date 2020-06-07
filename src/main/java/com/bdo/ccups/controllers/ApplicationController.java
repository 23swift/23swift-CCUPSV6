package com.bdo.ccups.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("api")
public class ApplicationController {
@Autowired
ApplicationRepository appRepo;
// 
@GetMapping("applications")
 public List<Application> GetApplications() {
     return appRepo.findAll();
 }

 @PostMapping("applications")
 public Application GetApplications(@RequestBody Application newApplication) {
   
   
     return appRepo.saveAndFlush(newApplication);
}
    
}