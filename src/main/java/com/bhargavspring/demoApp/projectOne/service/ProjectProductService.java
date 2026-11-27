package com.bhargavspring.demoApp.projectOne.service;

import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.repo.ProjectProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectProductService {

    @Autowired
    private ProjectProductRepo repo;  //Connecting with our Repository Layer

    public List<ProjectProduct> getAllProducts() {
        return repo.findAll();  //Returning the List of products
    }

    public ProjectProduct getProductById(int id) {
        return repo.findById(id).orElse(null);
    }


    //Adding the New Product and Image and also saving the adding product and image
    public ProjectProduct addProduct(ProjectProduct product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repo.save(product);  //Saving the product.
    }


    //Update Logic
    public ProjectProduct updateProduct(int id, ProjectProduct product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    //Delete Logic
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

}
