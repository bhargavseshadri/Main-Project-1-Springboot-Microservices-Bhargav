package com.bhargavspring.demoApp.model;


/*BhargavSeshadri -- Step:3 -- This is the main Controller class
 * Step: 2 -- Service Layer : com/bhargavspring/demoApp/service/ProductService.java
 * Step: 1 -- Model : com/bhargavspring/demoApp/model/Product.java
 * */
public class Product {

    private int prodId;
    private String prodName;

    public Product(int prodId, int price, String prodName) {
        this.prodId = prodId;
        this.price = price;
        this.prodName = prodName;
    }

    private int price;

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
