package com.bhargavspring.demoApp.service;

import com.bhargavspring.demoApp.model.Product;
import com.bhargavspring.demoApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/*BhargavSeshadri -- Step:3 -- This is the main Service class
 * Step: 2 -- Service Layer : com/bhargavspring/demoApp/service/ProductService.java
 * Step: 1 -- Model : com/bhargavspring/demoApp/model/Product.java
 * */
@Service
public class ProductService {

    //CURD OPERATIONS WITHOUT USING JPA
//
//    // Product constructor order is: product ID, price, product name.
//    private final List<Product> products = new ArrayList<> (List.of(
//            new Product(101, 50000, "Iphone"),
//            new Product(102, 70000, "Canon Camera"),
//            new Product(103, 10000, "Shure Mic"))
//    );
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public Product getProductByGivenId(int prodId) {  // this method will return the product based on the given productID in the API endpoint url
//        // Check each product in the list and return the one with the matching ID.
//        for (Product product : products) {
//            if (product.getProdId() == prodId) {
//                return product;
//            }
//        }
//
//        // Return this product when no matching ID is found.
//        return new Product(100, 0, "No Item");
//    }
//
//    public void addNewProduct(Product prod) {
//        products.add(prod);
//    }
//
//    public void updateProductinList(Product prod) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++)
//            if (products.get(i).getProdId() == prod.getProdId())
//                index = i;
//        products.set(index, prod);
//
//
//    }
//
//    public void deleteProductinList(int prodId) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++)
//            if (products.get(i).getProdId() == prodId)
//                index = i;
//        products.remove(index);
//
//    }





    //MAKING CURD OPERATIONS USING JPA
    @Autowired
    ProductRepo repo;

    public List<Product> getDBProducts() {
        return repo.findAll();
    }

    public Product getProductByIdfromDB(int prodId) {
        return repo.findById(prodId).orElse(new Product(100, 0, "No Item"));
    }

    public void addProductToDB(Product prod) {
        repo.save(prod);
    }

    public void updateDBProduct(Product prod) {
        repo.save(prod);


    }

    public void deleteDBProductByID(int prodId) {
        repo.deleteById(prodId);

    }

}
