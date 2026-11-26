package com.bhargavspring.demoApp.controller.product;


import com.bhargavspring.demoApp.model.Product;
import com.bhargavspring.demoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {  // this method is responsible to give that particular product when we give the prod id in API endpoint
        return service.getProductByGivenId(prodId);
    }


    //Example for making POST Request
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod) {
        service.addNewProduct(prod);
    }

    //update product
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod) {
        service.updateProductinList(prod);
    }

    //delete product
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProductinList(prodId);
    }
}
