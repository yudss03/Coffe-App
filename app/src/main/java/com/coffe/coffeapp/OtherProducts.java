package com.coffe.coffeapp;

public class OtherProducts {
    private String otherProductTitle;
    private int otherProductPrice;
    public OtherProducts(String otherProductTitle, int otherProductPrice) {
        this.otherProductTitle = otherProductTitle;
        this.otherProductPrice = otherProductPrice;
    }

    public String getOtherProductTitle() {
        return otherProductTitle;
    }

    public int getOtherProductPrice() {
        return otherProductPrice;
    }
}
