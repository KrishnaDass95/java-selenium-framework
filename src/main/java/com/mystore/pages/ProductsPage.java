package com.mystore.pages;

// import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mystore.utils.WaitUtils;

public class ProductsPage {

    // Locators
    private final By logoutButton = By.xpath("//button[normalize-space()='Logout']");
    private final By productCards = By.cssSelector(".card");
    // private final By productTitle = By.xpath(".//p[1]");
    private final By addToCartButton = By.xpath(".//button");
    private final By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");
    private final By cartImage = By.cssSelector(".image-container");

    public boolean isLogoutButtonVisible(){
        try{
            return WaitUtils.waitForVisibility(logoutButton).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isPageLoaded(){
        // Check if the product cards are shown
        try{
            return !WaitUtils.waitForAllElementVisible(productCards).isEmpty();
        }
        catch (Exception e){
            return false;
        }
    }

    public void addFirstProductToCart(){
        List<WebElement> cards = WaitUtils.waitForAllElementVisible(productCards);
        WebElement firstCard = cards.get(0);
        firstCard.findElement(addToCartButton).click();
    }

    public int getCartCount(){
        List<WebElement> cartImages = WaitUtils.waitForAllElementVisible(cartImage);
        return cartImages.size();

    }

    public void goToCheckout(){
        WaitUtils.waitForClickable(checkoutButton).click();
    }
    

}
