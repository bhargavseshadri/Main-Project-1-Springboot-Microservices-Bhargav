package com.bhargavspring.demoApp.controller.product;


import com.bhargavspring.demoApp.model.Product;
import com.bhargavspring.demoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*BhargavSeshadri -- Step:3 -- This is the main Controller class
* Step: 2 -- Service Layer : com/bhargavspring/demoApp/service/ProductService.java
* Step: 1 -- Model : com/bhargavspring/demoApp/model/Product.java
* */

@RestController  // Making the class a controller class
public class ProductController {

    @Autowired  //Using one java class in another java class
    ProductService service;


    //The Spring will simply return the products in response in a JSON format.
    @RequestMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();  //Using the created object we are getting the products from the service.
    }
}
