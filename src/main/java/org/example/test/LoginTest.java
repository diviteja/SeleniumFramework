package org.example.test;

import org.example.pageobjects.Loginpage;
import org.example.pageobjects.base.BaseTest;
import org.example.utils.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    Loginpage loginpage = new Loginpage();

    public static final String email = Message.getMessage("email1");
    public static final String password = Message.getMessage("password");

    @Test(description = "login flow check")
    public void login(){
        driver.get(Message.getMessage("portal"));
        loginpage.loginUser(driver, email, password);
        clickElement(loginpage.submit());
        WebElement hompages=driver.findElement(By.xpath(loginpage.homepage()));
        Assert.assertTrue(hompages.isDisplayed());
        logger.info("login Test completed sucessfully");
    }
}
