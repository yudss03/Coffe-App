package com.coffe.coffeapp;

public class OtherProductsModel {
    private String productTitle;
    private int productPrice;
    private String productImg;

    public OtherProductsModel() {

    }
    public OtherProductsModel(String productTitle, int productPrice, String productImg) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productImg = productImg;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductImg() { return  productImg; }
}
