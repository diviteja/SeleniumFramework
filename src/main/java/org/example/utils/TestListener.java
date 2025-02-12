package org.example.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result){
        String testname = result.getMethod().getMethodName();
        try {
            String destination = ScreenshotConfig.takeScreenshot(DriverManager.getDriver(),testname);
            if(!destination.isEmpty()){
                logger.info("{} Test is failed and Screenshot Saved in {} path. ",testname,destination);
            }
        } catch (IOException e) {
            logger.error("{} Test is failed and Unable to take Screenshot. Exception: {}", testname, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testname = result.getMethod().getMethodName();
        logger.info("{} Test passed successfully.", testname);
    }

}
