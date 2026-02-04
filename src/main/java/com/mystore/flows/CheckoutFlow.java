package com.mystore.flows;

import com.mystore.pages.CheckoutPage;

public class CheckoutFlow {

    private CheckoutPage checkoutPage;

    public CheckoutFlow(){
        checkoutPage = new CheckoutPage();
    }

    public void completeCheckout(String address){
        checkoutPage.addAddress(address);
        checkoutPage.selectAddress();
        checkoutPage.placeOrder();
    }

    public boolean isOrderConfirmed(){
        return checkoutPage.isOrderPlaced();
    }
    
}
