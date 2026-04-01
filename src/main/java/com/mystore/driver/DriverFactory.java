package com.mystore.driver;
import java.net.MalformedURLException;
import java.net.URL;
import javax.management.RuntimeErrorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.mystore.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static void initDriver(){

        // getting info from config file
        String browser = ConfigReader.getInstance().getProperty("browser");
        String headless = ConfigReader.getInstance().getProperty("headless");
        String executionMode = System.getProperty("executionMode", ConfigReader.getInstance().getProperty("executionMode"));

        WebDriver driver;

        if (executionMode.equalsIgnoreCase("grid")){
            driver = createRemotWebDriver(browser, headless);
        }
        else{
            driver = createLocalDriver(browser, headless);
        }

        DriverManager.setDriver(driver);
        driver.manage().window().maximize();

    }


    private static WebDriver createLocalDriver(String browser, String headless){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if(headless.equalsIgnoreCase("true")){
                    options.addArguments("--headless=new");
                }
                return new ChromeDriver(options);
            
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless.equalsIgnoreCase("true")) {
                    firefoxOptions.addArguments("--headless");
                }
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeErrorException(null, "unsupported browser" + browser);
    }
}

    private static WebDriver createRemotWebDriver(String browser, String headless){
        String gridUrl = ConfigReader.getInstance().getProperty("gridUrl");
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    // Best practice for Docker grid execution
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    return new RemoteWebDriver(new URL(gridUrl), chromeOptions);

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    return new RemoteWebDriver(new URL(gridUrl), firefoxOptions);

                default:
                    throw new RuntimeException("Unsupported grid browser: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Grid URL is invalid: " + gridUrl, e);
        }
    }


    public static void quitDriver(){
        if (DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
    

