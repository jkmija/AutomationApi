package com.api.steps;


public class Price {
    private String product;
    private String currency;

    public Price(String product, String currency) {
        this.product = product;

        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }


    public String getCurrency() {
        return currency;
    }
}
