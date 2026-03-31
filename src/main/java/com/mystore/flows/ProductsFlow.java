package com.mystore.flows;

import com.mystore.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Step;

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
    
    @Step("Add first product to cart")
    public void addFirstProductToCart(){
        logger.info("Adding product to cart");
        productsPage.addFirstProductToCart();
    }

    @Step("Get cart count")
    public int getCartCount(){
        return productsPage.getCartCount();
    }

    @Step("Go to checkout page")
    public void goToCheckoutPage(){
        logger.info("Go to checkout page");
        productsPage.goToCheckout();
    }


}
