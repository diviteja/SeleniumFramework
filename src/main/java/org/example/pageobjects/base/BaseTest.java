package org.example.pageobjects.base;

import org.example.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.example.utils.Message;

import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void init(){
        driver = Webdriver.getDriver();
    }
    protected void navigateto(String URL){
        driver.navigate().to(URL);
    }

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
