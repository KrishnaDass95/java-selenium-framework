package com.mystore.flows;

import com.mystore.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFlow {

    private static final Logger logger = 
        LoggerFactory.getLogger(LoginFlow.class);
    private LoginPage loginPage;

    public LoginFlow(){
        this.loginPage = new LoginPage();
    }

    public void loginAs(String username, String password){

        logger.info("Opening login page");
        this.loginPage.open();
        logger.info("logging in as a standard user with email {}", username);
        this.loginPage.login(username, password);
    }
}
