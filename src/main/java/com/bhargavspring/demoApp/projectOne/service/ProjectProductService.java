package com.bhargavspring.demoApp.projectOne.service;

import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.repo.ProjectProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductService {

    @Autowired
    private ProjectProductRepo repo;  //Connecting with our Repository Layer

    public List<ProjectProduct> getAllProducts() {
        return repo.findAll();  //Returning the List of products
    }
}
