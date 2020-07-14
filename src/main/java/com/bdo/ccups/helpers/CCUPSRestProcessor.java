package com.bdo.ccups.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import com.bdo.ccups.controllers.ApplicationController;
import com.bdo.ccups.model.*;
import org.springframework.hateoas.*;
import org.springframework.hateoas.config.*;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.core.DummyInvocationUtils;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.Link;
@Component
public class CCUPSRestProcessor implements RepresentationModelProcessor<EntityModel<Application>> {
    @Autowired
    EntityLinks links;
    // @Autowired
    // RepositoryRestConfiguration configuration;

    @Override
    public EntityModel<Application> process(EntityModel<Application> model) {
        // TODO Auto-generated method stub
        
             model.add(links.linkForItemResource( Product.class,model.getContent().getProduct().getId()).withRel("props").withName(Product.class.getSimpleName().toLowerCase()));
             Link link = WebMvcLinkBuilder.linkTo(DummyInvocationUtils.methodOn(ApplicationController.class).submitApplication(model.getContent().getId().toString())).withRel("action");
            

             if(model.getContent().getStatus().equalsIgnoreCase("")){
               
                model.add(model.getLink("self").get().withRel("action").withTitle("Delete").withType("delete").withName("delete"));
                model.add(model.getLink("self").get().withRel("action").withTitle("Update").withType("PUT").withName("update"));
                // model.add(model.getLink("self").get().withRel("controls").withTitle("Submit to Approver").withType("button").withName("submit"));
                model.add(link.withTitle("Submit to Approver").withType("PUT").withName("submit"));
             }else  
             {
                model.add(model.getLink("self").get().withRel("action").withTitle("Approve").withType("PUT").withName("approve"));
                model.add(model.getLink("self").get().withRel("action").withTitle("Decline").withType("PUT").withName("decline"));
                
             }

             
             
             

             
             
             
        return model;

    }

}