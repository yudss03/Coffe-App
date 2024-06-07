package com.coffe.coffeapp;

public class ProductModel {
    String productTitle;
    int productPrice;

    public ProductModel(String productTitle, int productPrice) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

}
