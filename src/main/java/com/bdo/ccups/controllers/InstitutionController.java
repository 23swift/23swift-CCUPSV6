package com.bdo.ccups.controllers;

import java.util.List;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstitutionController {
@Autowired
InstitutionRepository institutionRepository;

@Autowired
ProductRepository productRepository;

    @GetMapping("institutions")
 public Iterable<Institution> GetApplications() throws Exception {
     
     return institutionRepository.findAll();
 }

 @ResponseStatus(code = HttpStatus.CREATED)
 @PostMapping("institutions")
    public Institution PostInstitution(@RequestBody Institution newInstitution) throws Exception
    {

                return institutionRepository.save(newInstitution);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("institutions")
       public Institution PutInstitution(@RequestBody Institution newInstitution) throws Exception
       {
   
                   return institutionRepository.save(newInstitution);
       }
    //    @ResponseStatus(code = HttpStatus.OK)
    //    @PutMapping("addProduct")
    //       public Product AddProduct(@RequestBody Institution newInstitution) throws Exception
    //       {
    //                 Product product=productRepository.saveAndFlush(entity)
    //                   return institutionRepository.saveAndFlush(newInstitution);
    //       }
}