package com.codescratcher.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);
    private static WebDriver driver;

    private DriverManager() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver initializeDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-blink-features=AutomationControlled");
            // Additional recommended options for stability
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");    

            driver = new ChromeDriver(options);

            log.info("Chrome driver initialized successfully");
            
            return driver;
        } catch (Exception e) {
            log.error("Failed to initialize Chrome driver: {}", e.getMessage());
            throw e;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
