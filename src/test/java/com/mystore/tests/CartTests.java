package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.flows.ProductsFlow;
import com.mystore.listeners.RetryAnalyzer;

public class CartTests extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"smoke", "cart"})
    public void incrementCartCountWhenProductsAdded() throws InterruptedException{
        createFreshUser();
        ProductsFlow productsFlow = new ProductsFlow();
        productsFlow.addFirstProductToCart();
        // Thread.sleep(3000);
        int cartCount = productsFlow.getCartCount();
        Assert.assertEquals(cartCount, 1, String.format("Cart count mismatch, expected 1 but recieved: %d", cartCount));
    }
    
}
