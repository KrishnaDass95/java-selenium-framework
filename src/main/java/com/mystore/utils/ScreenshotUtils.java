package com.mystore.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;

import com.mystore.driver.DriverManager;

public class ScreenshotUtils {

    public static String captureScreenshot(String testName){

        try{
            // double brackets because you want the casting to occur before the method is called
            // webdriver is converted to a camera temporarily (analogy)
            File srcFile = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

            Path destination = Path.of("test-output/screenshots/" + testName + ".png");
            Files.createDirectories(destination.getParent());

            Files.copy(srcFile.toPath(), destination);

            return destination.toString();
        }
        catch(Exception e){
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] saveScreenshotToAllure() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    
}
