package com.bdo.ccups.controllers;

import java.util.List;
import java.util.Optional;

import com.bdo.ccups.model.Institution;
import com.bdo.ccups.model.Product;
import com.bdo.ccups.repo.InstitutionRepository;
import com.bdo.ccups.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InstitutionRepository institutionRepository;

//     @GetMapping("productsByInstitutionId") 
//     public List<Product> GetProductsByInstitution(Long Id) throws Exception {
//           Optional< Institution> institution= institutionRepository.findById(Id);
//           institution.orElseThrow(()-> new Exception("Institution not Found!") );
             
//           return institution.get().getProducts();
        
//     }
//    @PostMapping("products") 
//    public Product PostProduct(@RequestBody Product newProduct,@RequestParam Long id) throws Exception {
//                   Product product=productRepository.saveAndFlush(newProduct);
//                   Institution institution= institutionRepository.findById(id).get();
//                   institution.getProducts().add(product);
//                   institutionRepository.saveAndFlush(institution);
//             return newProduct;
//    }
    
}