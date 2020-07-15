package com.bdo.ccups.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;


@Component
public class ProductRestProcessor implements RepresentationModelProcessor<EntityModel<Product>> {
    @Autowired
    EntityLinks links;

    @Override
    public EntityModel<Product> process(EntityModel<Product> model) {
        // Product product =model.getContent();
        // model.getContent().setName(product.getInstitution().getName()+" - "+product.getName());
        return model;
    }
}