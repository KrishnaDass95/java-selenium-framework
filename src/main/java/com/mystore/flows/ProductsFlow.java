package com.mystore.flows;

import com.mystore.pages.ProductsPage;

public class ProductsFlow {

    private ProductsPage productsPage;

    public ProductsFlow(){
        this.productsPage = new ProductsPage();
    }

    public boolean isUserOnProductPage(){
        return productsPage.isPageLoaded();
    }
    
    public void addFirstProductToCart(){
        productsPage.addFirstProductToCart();
    }

    public int getCartCount(){
        return productsPage.getCartCount();
    }

    public void goToCheckoutPage(){
        productsPage.goToCheckout();
    }


}
