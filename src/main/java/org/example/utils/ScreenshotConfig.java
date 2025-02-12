package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotConfig {

    public static String takeScreenshot(WebDriver driver, String testname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scs = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/" + testname + ".png");
        Files.copy(scs.toPath(), destination.toPath());
        return destination.getAbsolutePath();
    }


}
