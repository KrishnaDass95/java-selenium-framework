package com.mystore.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.mystore.driver.DriverFactory;
import com.mystore.flows.UserFlow;
import com.mystore.models.User;

public class BaseTest {

    public User testUser;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser){
        DriverFactory.initDriver(browser);
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
