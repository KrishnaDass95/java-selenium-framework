package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.flows.LoginFlow;
import com.mystore.pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void shouldLoginWithValidCredentials(){

        LoginFlow loginFlow = new LoginFlow();
        loginFlow.loginAs("testkd", "test123");
        ProductsPage productsPage = new ProductsPage();
        Assert.assertTrue(productsPage.isLogoutButtonVisible(), "Logout button not visible after successful login");
        
    }
    
}
