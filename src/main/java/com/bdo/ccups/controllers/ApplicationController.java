package com.bdo.ccups.controllers;


import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;



// import com.bdo.ccups.ExceptionHandlers.EntityNotFoundException;
import com.bdo.ccups.model.Application;
import com.bdo.ccups.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.core.DummyInvocationUtils;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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


@RepositoryRestController
//  @RequestMapping("api")                      localhost:8080/api/applications
public class ApplicationController {
@Autowired
private  ApplicationRepository appRepo;
// @Autowired
// private  Link linkTo;

// @GetMapping("/myapplications")
// public ResponseEntity<EntityModel<Application>> findApplicationById(@PathVariable("id") long id){

//  Link link = WebMvcLinkBuilder.linkTo(DummyInvocationUtils.methodOn(ApplicationController.class).findApplicationById(id)).withRel("product");


//  EntityModel<Application>  application=  EntityModel.of(appRepo.findById(id).get(),link);
    
   
// 	return ResponseEntity.ok(application);
// }

}