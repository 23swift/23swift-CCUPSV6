package com.bdo.ccups.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import com.bdo.ccups.model.*;
import org.springframework.hateoas.*;
import org.springframework.hateoas.config.*;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
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
        
             model.add(links.linkForItemResource( Product.class,model.getContent().getProduct().getId()).withRel("product"));
           
        return model;

    }

}