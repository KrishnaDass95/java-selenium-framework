package com.mystore.flows;

import com.mystore.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductsFlow {

    private static final Logger logger = 
        LoggerFactory.getLogger(ProductsFlow.class);

    private ProductsPage productsPage;

    public ProductsFlow(){
        this.productsPage = new ProductsPage();
    }

    public boolean isUserOnProductPage(){
        return productsPage.isPageLoaded();
    }
    
    public void addFirstProductToCart(){
        logger.info("Adding product to cart");
        productsPage.addFirstProductToCart();
    }

    public int getCartCount(){
        return productsPage.getCartCount();
    }

    public void goToCheckoutPage(){
        logger.info("Go to checkout page");
        productsPage.goToCheckout();
    }


}
