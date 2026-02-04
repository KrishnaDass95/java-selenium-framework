package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.flows.LoginFlow;
import com.mystore.flows.ProductsFlow;

public class CartTests extends BaseTest{

    @Test
    public void incrementCartCountWhenProductsAdded(){
        LoginFlow login = new LoginFlow();
        login.loginAs("testkd", "test123");
        ProductsFlow productsFlow = new ProductsFlow();
        productsFlow.addFirstProductToCart();
        int cartCount = productsFlow.getCartCount();
        Assert.assertEquals(cartCount, 1, String.format("Cart count mismatch, expected 1 but recieved: %d", cartCount));
    }
    
}
