package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Webdriver{

    // Method to initialize WebDriver based on browser type and config file
    public static WebDriver getDriver() {
        WebDriver driver = null;
        String browser = Message.getMessage("browser");
        String driverPath = Message.getMessage(browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("chromedriver", driverPath);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("firefoxdriver", driverPath);
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Common setup (timeout, maximize window)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}

