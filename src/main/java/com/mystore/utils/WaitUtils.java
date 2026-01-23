package com.mystore.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.driver.DriverManager;

public class WaitUtils {

    private static WebDriverWait getWait(){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitForVisibility(By locator){
        return getWait().until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement waitForClickable(By locator){
        return getWait().until(
            ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static void waitForText(By locator, String text){
        getWait().until(
            ExpectedConditions.textToBePresentInElementLocated(locator, text)
        );
    }    
}
