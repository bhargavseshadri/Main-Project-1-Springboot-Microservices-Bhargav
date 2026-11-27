package com.bhargavspring.demoApp.projectOne.controller;


import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  //This annotation is used to bypass the CORS error. (our frontend can interact with the backend)
@RequestMapping("/api")  //when we use the @RequestMapping on top of the controller, then we have to use this with all the other endpoints like /api/products
public class ProjectProductController {

    @Autowired
    private ProjectProductService service;  //Service Object

    @RequestMapping("/home")
    public String greet() {
        return "Hello World";
    }


    @GetMapping("/products/{prodId}")
    public ProjectProduct getProductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProjectProduct>> getAllProductsStatus() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProjectProduct> getProduct(@PathVariable int id) {
        ProjectProduct product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
