package com.bdo.ccups.helpers;

import com.bdo.ccups.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class ResourceHelper {
    @Autowired
    EntityLinks entityLinks;

    public Link getProductSelfLink(Product product) {
        return this.entityLinks.linkForItemResource(Product.class, product.getId())
                .withSelfRel();
      }
}