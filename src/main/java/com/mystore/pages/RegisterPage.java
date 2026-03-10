package com.mystore.pages;

import org.openqa.selenium.By;

import com.mystore.config.ConfigReader;
import com.mystore.driver.DriverManager;
import com.mystore.utils.WaitUtils;

public class RegisterPage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By registerPageTitleText = By.xpath("//h2[@class='title']");
    private final By registerButton = By.xpath("//button[text()='Register Now']");
    private final By loginButton = By.xpath("//button[text()='Login to QKart']");

    public void openPage(){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        DriverManager.getDriver().get(baseUrl + "register");
        WaitUtils.waitForText(registerPageTitleText, "Register");
    }

    public void registerNewUser(String username, String password, String confirmPassword){
        WaitUtils.waitForVisibility(usernameInput).sendKeys(username);
        WaitUtils.waitForVisibility(passwordInput).sendKeys(password);
        WaitUtils.waitForVisibility(confirmPasswordInput).sendKeys(confirmPassword);
        WaitUtils.waitForVisibility(registerButton).click();
        WaitUtils.waitForVisibility(loginButton);
    }

    
}
