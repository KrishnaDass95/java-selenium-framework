package com.mystore.base;

import org.testng.annotations.Test;

import com.mystore.config.ConfigReader;

public class TestConfig {

    @Test
    public void testConfigLoad(){
        ConfigReader config = ConfigReader.getInstance();
        String browser = config.getProperty("browser");
        System.out.println("Browser = " + browser);
    }
    
}
