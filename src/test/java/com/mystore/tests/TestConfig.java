package com.mystore.tests;

import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.config.ConfigReader;
import com.mystore.flows.LoginFlow;

public class TestConfig extends BaseTest{

    // @Test
    // public void testConfigLoad(){
    //     ConfigReader config = ConfigReader.getInstance();
    //     String browser = config.getProperty("browser");
    //     System.out.println("Browser = " + browser);
    // }

    @Test
    public void testLoginBase(){
        LoginFlow loginFlow = new LoginFlow();
        loginFlow.loginAs("testkd", "test123");
    }
    
}
