package com.bhargavspring.demoApp.projectOne.controller;


import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")  //when we use the @RequestMapping on top of the controller, then we have to use this with all the other endpoints like /api/products
public class ProjectProductController {

    @Autowired
    private ProjectProductService service;  //Service Object

    @RequestMapping("/home")
    public String greet() {
        return "Hello World";
    }


    @GetMapping("/products")
    public List<ProjectProduct> getAllProducts() {
        return service.getAllProducts();  //linking with the Service Layer
    }
}
