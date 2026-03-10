package com.mystore.flows;

import com.mystore.config.TestDataReader;
import com.mystore.models.User;
import com.mystore.pages.LoginPage;
import com.mystore.pages.RegisterPage;
import com.mystore.utils.TestDataFactory;

public class UserFlow {

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
        loginPage.login(email, password);

        return new User(email, password);

    }


    
}
