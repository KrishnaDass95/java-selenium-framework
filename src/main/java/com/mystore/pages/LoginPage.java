package com.mystore.pages;

import org.openqa.selenium.By;

import com.mystore.config.ConfigReader;
import com.mystore.driver.DriverManager;
import com.mystore.utils.WaitUtils;

public class LoginPage {

    //Locators
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button.button");
    private final By loginErrorMessage = By.id("notistack-snackbar");

    public void open(){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        DriverManager.getDriver().get(baseUrl + "login");
        WaitUtils.waitForVisibility(usernameInput);
    }

    public void login(String userName, String password){
        WaitUtils.waitForVisibility(usernameInput).sendKeys(userName);
        WaitUtils.waitForVisibility(passwordInput).sendKeys(password);
        WaitUtils.waitForClickable(loginButton).click();
    }

    public boolean isLoginErrorMessageVisible(){
        return WaitUtils.waitForVisibility(loginErrorMessage).isDisplayed();
    }
    
}
