package com.mystore.flows;

import com.mystore.config.TestDataReader;
import com.mystore.models.User;
import com.mystore.pages.LoginPage;
import com.mystore.pages.RegisterPage;
import com.mystore.utils.TestDataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFlow {

      private static final Logger logger = 
        LoggerFactory.getLogger(UserFlow.class);

    private RegisterPage registerPage;
    private LoginPage loginPage;

    public UserFlow(){
        this.registerPage = new RegisterPage();
        this.loginPage = new LoginPage();
    }

    public User createAndLoginUser(){

        String email = TestDataFactory.generateUserEmail();
        String password = TestDataReader.getInstance().get("defaultPassword");

        registerPage.openPage();
        registerPage.registerNewUser(email, password, password);

        loginPage.open();
        logger.info("Logging in with: {}", email);
        loginPage.login(email, password);

        return new User(email, password);

    }


    
}
