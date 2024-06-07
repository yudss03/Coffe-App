package com.coffe.coffeapp;

public class PointModel {
    String productTitle;
    int productPoint;

    public PointModel(String productTitle, int productPoint){
        this.productTitle=productTitle;
        this.productPoint=productPoint;
    }

    public String getProductTitle(){
        return productTitle;
    }

    public int getProductPoint(){
        return productPoint;
    }
}
