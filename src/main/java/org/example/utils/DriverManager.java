package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to initialize WebDriver based on browser type and config file
    public static void init() {
        if (driver.get() == null) {
            String driverPath = Message.getMessage("chromedriver");
            String browser = Message.getMessage("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", driverPath);
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            init();
        }
        return driver.get();
    }
}

