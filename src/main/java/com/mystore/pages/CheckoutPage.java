package com.mystore.pages;

import org.openqa.selenium.By;

import com.mystore.utils.WaitUtils;

public class CheckoutPage {

    // Locators
    private final By addAddressButton = By.id("add-new-btn");
    private final By addressTextArea = By.xpath("//textarea[@placeholder='Enter your complete address']");
    private final By postAddressAddButton = By.xpath("//button[text()='Add']");
    private final By addressSelectRadioButton = By.cssSelector(".address-item");
    private final By placeOrderButton = By.xpath("//button[contains(text(), 'ORDER')]");
    // private final By orderConfirmationSnackBar = By.id("#notistack-snackbar"); // Order placed successfully!
    private final By orderConfirmationText = By.cssSelector(".greeting-container");
    private final By orderConfirmationInnerText = By.xpath(".//h2");

    public void addAddress(String addressText){
        WaitUtils.waitForVisibility(addAddressButton).click();
        WaitUtils.waitForVisibility(addressTextArea)
            .sendKeys(addressText);
        WaitUtils.waitForClickable(postAddressAddButton).click();
    }

    public void selectAddress(){
        WaitUtils.waitForVisibility(addressSelectRadioButton).click();
    }

    public void placeOrder(){
        WaitUtils.waitForVisibility(placeOrderButton).click();
    }

    public boolean isOrderPlaced(){
        String text = WaitUtils.waitForVisibility(orderConfirmationText)
            .findElement(orderConfirmationInnerText).getText();
        return text.contains("It's ordered");
    }



    
}
