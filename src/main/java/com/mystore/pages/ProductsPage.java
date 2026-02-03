package com.mystore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mystore.utils.WaitUtils;

public class ProductsPage {

    // Locators
    private final By logoutButton = By.xpath("//button[normalize-space()='Logout']");
    private final By productCards = By.cssSelector(".card");
    private final By productTitle = By.xpath(".//p[1]");

    public boolean isLogoutButtonVisible(){
        try{
            return WaitUtils.waitForVisibility(logoutButton).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }


    public boolean isPageLoaded(){
        // Check if the product titles are shown
        try{
            return !WaitUtils.waitForAllElementVisible(productCards).isEmpty();
        }
        catch (Exception e){
            return false;
        }
    }
    
}
