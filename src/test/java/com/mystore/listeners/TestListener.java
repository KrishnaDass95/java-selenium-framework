package com.mystore.listeners;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mystore.driver.DriverManager;
import com.mystore.utils.ScreenshotUtils;

import io.qameta.allure.Allure;

public class TestListener implements  ITestListener{

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test success!: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed: " + result.getName());
        ScreenshotUtils.captureScreenshot(result.getName());
        // 2. Attach it to Allure so it shows up in the report
        ScreenshotUtils.saveScreenshotToAllure();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    
    // If it's not a success (meaning it failed and then skipped/retried)
    if (!result.isSuccess()) {
        System.out.println("Attaching screenshot for failed retry...");
        
        // Use the simple attachment method
        try {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                                .getScreenshotAs(OutputType.BYTES);
            
            // This is the simplest way to attach to Allure
            Allure.addAttachment("Failure Screenshot - " + result.getName(), 
                                 new ByteArrayInputStream(screenshot));
                                 
        } catch (Exception e) {
            System.err.println("Allure attachment failed: " + e.getMessage());
        }
    }
    }
    
}
