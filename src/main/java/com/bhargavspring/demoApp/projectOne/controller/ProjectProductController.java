package com.bhargavspring.demoApp.projectOne.controller;


import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<ProjectProduct> getProductById(@PathVariable int prodId) {
        ProjectProduct product = service.getProductById(prodId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
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

    //Adding the New Product and Image
    @PostMapping(value = "/product", consumes = "multipart/form-data")
    public ResponseEntity<?> addProduct(
            @RequestPart("product") ProjectProduct product,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            ProjectProduct product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Method for getting the image from db using the product Id, this below endpoint is used in the React href tags
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        ProjectProduct product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);

    }


    //Update Logic
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart ProjectProduct product, @RequestPart MultipartFile imageFile) {

        ProjectProduct product1 = null;
        try {
            product1 = service.updateProduct(id, product, imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
        if (product1 != null) {
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }


    }


    //Delete Logic
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        ProjectProduct product = service.getProductById(id);
        if (product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

    }


}
