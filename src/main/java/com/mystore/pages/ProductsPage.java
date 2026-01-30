package com.mystore.pages;

import org.openqa.selenium.By;

import com.mystore.utils.WaitUtils;

public class ProductsPage {

    // Locators
    private final By logoutButton = By.xpath("//button[normalize-space()='Logout']");

    public boolean isLogoutButtonVisible(){
        try{
            return WaitUtils.waitForVisibility(logoutButton).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    
}
