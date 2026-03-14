package com.mystore.flows;

import com.mystore.pages.CheckoutPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutFlow {

    private static final Logger logger = 
        LoggerFactory.getLogger(CheckoutFlow.class);

    private CheckoutPage checkoutPage;

    public CheckoutFlow(){
        checkoutPage = new CheckoutPage();
    }

    public void completeCheckout(String address){
        logger.info("Entering address and placing order");
        checkoutPage.addAddress(address);
        checkoutPage.selectAddress();
        checkoutPage.placeOrder();
    }

    public boolean isOrderConfirmed(){
        return checkoutPage.isOrderPlaced();
    }
    
}
