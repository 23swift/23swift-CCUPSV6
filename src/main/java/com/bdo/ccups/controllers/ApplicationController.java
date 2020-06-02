
package com.bdo.ccups.controllers;

import java.util.List;

import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApplicationController
 */
@RestController
 public class ApplicationController {

    @Autowired
    ApplicationRepository appRepo;

    @GetMapping("Message")
    public String Message() {

        return "HEllo";
    }
    @GetMapping("applications")
    public List<Application> GetApplications(){

        return appRepo.findAll();
    }
    
}