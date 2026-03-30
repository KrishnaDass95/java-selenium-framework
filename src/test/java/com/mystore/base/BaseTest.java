package com.mystore.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.driver.DriverFactory;
import com.mystore.flows.UserFlow;
import com.mystore.models.User;

public class BaseTest {

    public User testUser;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        DriverFactory.initDriver();
    }

    public void createFreshUser(){
        UserFlow userFlow = new UserFlow();
        testUser = userFlow.createAndLoginUser();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
    
}
