package com.mystore.driver;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mystore.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static void initDriver(){

        String browser = ConfigReader.getInstance().getProperty("browser");
        String headless = ConfigReader.getInstance().getProperty("headless");

        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if(headless.equalsIgnoreCase("true")){
                    options.addArguments("--headless=new");
                }
                driver = new ChromeDriver(options);
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
