package com.mystore.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mystore.utils.ScreenshotUtils;

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
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    }
    
}
