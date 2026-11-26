package com.bhargavspring.demoApp.model;


/*BhargavSeshadri -- Step:3 -- This is the main Controller class
 * Step: 2 -- Service Layer : com/bhargavspring/demoApp/service/ProductService.java
 * Step: 1 -- Model : com/bhargavspring/demoApp/model/Product.java
 * */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity   //This annotation is needed to create a table in the DB using JPA
public class Product {

    @Id  //Making this variable(becomes column in the DB) as Primary Key.
    private int prodId;
    private String prodName;
    private int price;

    // JPA needs a no-argument constructor to load products from the database.
    public Product() {
    }

    public Product(int prodId, int price, String prodName) {
        this.prodId = prodId;
        this.price = price;
        this.prodName = prodName;
    }



    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
