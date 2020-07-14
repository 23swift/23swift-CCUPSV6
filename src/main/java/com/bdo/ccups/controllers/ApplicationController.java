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
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RepositoryRestController

public class ApplicationController {
@Autowired
private  ApplicationRepository appRepo;

@Autowired
EntityLinks
 links;
// @Autowired
// private  Link linkTo;
@org.springframework.beans.factory.annotation.Value("${application.status.forApproval}")
String forApproval;
@RestResource(  rel = "actions" , path ="/applications/actions/submit/{id}" )
@RequestMapping(method = RequestMethod.PUT, value = "/applications/actions/submitApplication/{id}") 
public ResponseEntity<EntityModel<Application>> submitApplication(@PathVariable("id") String id){

 Link link = WebMvcLinkBuilder.linkTo(DummyInvocationUtils.methodOn(ApplicationController.class).submitApplication(id)).withSelfRel();

Application app=appRepo.findById(Long.parseLong(id) ).get();
app.setStatus(forApproval);
appRepo.save(app);
 EntityModel<Application>  application=    new EntityModel<> (  app,link);
    
   
	return ResponseEntity.ok(application);
}

}