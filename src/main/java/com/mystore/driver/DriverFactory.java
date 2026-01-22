package com.mystore.driver;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mystore.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static void initDriver(){

        String browser = ConfigReader.getInstance().getProperty("browser");

        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            
            default:
                throw new RuntimeErrorException(null, "unsupported browser" + browser);
        }
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

    public static void quitDriver(){
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
    
}
