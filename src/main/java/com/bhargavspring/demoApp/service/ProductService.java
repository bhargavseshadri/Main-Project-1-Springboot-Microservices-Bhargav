package com.bhargavspring.demoApp.service;

import com.bhargavspring.demoApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


/*BhargavSeshadri -- Step:3 -- This is the main Service class
 * Step: 2 -- Service Layer : com/bhargavspring/demoApp/service/ProductService.java
 * Step: 1 -- Model : com/bhargavspring/demoApp/model/Product.java
 * */
@Service
public class ProductService {

    // Product constructor order is: product ID, price, product name.
    private final List<Product> products = List.of(
            new Product(101, 50000, "Iphone"),
            new Product(102, 70000, "Canon Camera"),
            new Product(103, 10000, "Shure Mic")
    );

    public List<Product> getProducts() {
        return products;
    }
}
