package com.bdo.ccups.controllers;

import java.util.List;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.repo.InstitutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstitutionController {
@Autowired
InstitutionRepository institutionRepository;

    @GetMapping("institutions")
 public List<Institution> GetApplications() {
     
     return institutionRepository.findAll();
 }
    
}