package org.example.pageobjects;

import org.openqa.selenium.*;

public class Loginpage {

    public void loginUser(WebDriver driver, String email, String password) {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(email);
        driver.findElement(By.xpath(passwordXpath())).sendKeys(password);
    }

    public String passwordXpath(){ return "//input[@id = 'password']"; }

    public String submit(){ return "//button/span[text()='Sign In']"; }

    public String homepage(){ return "//h3[text() = 'Homepage']"; }
}
