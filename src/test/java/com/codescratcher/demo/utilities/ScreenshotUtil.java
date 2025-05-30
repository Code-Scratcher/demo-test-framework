package com.codescratcher.demo.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotUtil {
    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtil.class);
    // Directory to save screenshots
    private static final String screenShotDir = "test-output/screenshots";
    
    public ScreenshotUtil() {
        File screenShotDirFile = new File(screenShotDir);
        // Create the directory if it doesn't exist
        if (!screenShotDirFile.exists()) {
            screenShotDirFile.mkdirs();
        }
    }
    
    public void takeScreenshot(WebDriver driver, String testCaseName, String status ) {
        // Create a timestamp for the screenshot file name
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String fullFileName = testCaseName + "_" + status + "_" + dateFormat.format(new Date()) + ".png";

        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        File destinationFile = new File(screenShotDir, fullFileName);        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(screenshot, destinationFile);
            logger.info("Screenshot saved: {}", destinationFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", e.getMessage());
        }
    }
}

