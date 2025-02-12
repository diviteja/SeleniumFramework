package org.example.pageobjects.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void init(){
        driver = DriverManager.getDriver();
    }
    protected void navigateto(String URL){
        driver.navigate().to(URL);
    }

    public static final Logger logger = LogManager.getLogger(BaseTest.class);


    public void ispresent(String xpath){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }


    public void clickElement(String xpath){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
