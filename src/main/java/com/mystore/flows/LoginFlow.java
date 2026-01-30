package com.mystore.flows;

import com.mystore.pages.LoginPage;

public class LoginFlow {
    
    private LoginPage loginPage;

    public LoginFlow(){
        this.loginPage = new LoginPage();
    }

    public void loginAs(String username, String password){
        this.loginPage.open();
        this.loginPage.login(username, password);
    }
}
