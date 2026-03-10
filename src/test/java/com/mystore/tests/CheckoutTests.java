package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.flows.CheckoutFlow;
import com.mystore.flows.ProductsFlow;

public class CheckoutTests extends BaseTest{

    @Test
    public void shouldCompleteCheckout(){
        createFreshUser();

        ProductsFlow productsFlow = new ProductsFlow();
        productsFlow.addFirstProductToCart();
        productsFlow.goToCheckoutPage();

        CheckoutFlow checkoutFlow = new CheckoutFlow();
        checkoutFlow.completeCheckout("Los Angeles International Airport (LAX) is located at 1 World Way, Los Angeles, CA 90045");
        Assert.assertTrue(checkoutFlow.isOrderConfirmed());
        Assert.assertTrue(false);
    
    }
    
}
