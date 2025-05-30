package com.codescratcher.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codescratcher.demo.base.DriverManager;
import com.codescratcher.demo.pages.HomePage;
import com.codescratcher.demo.utilities.ScreenshotUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCase01 {
    private static final Logger log = LoggerFactory.getLogger(TestCase01.class);
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver
        this.driver = DriverManager.getDriver();
    }   
    @Test
    public void testCase01() {
        try {
            // Open the URL
            log.info("Test Case 01: Opening URL");
            driver.get("https://www.google.com/");

            log.info("Test Case 01: Searching for keyword 'Open AI'");
            String keywordToSearch = "Open AI";

            HomePage homepage = new HomePage(driver);
            log.info("Test Case 01: Entering keyword in search box");
            homepage.getSearchBoxWebElement().sendKeys(keywordToSearch);
            homepage.getSearchBoxWebElement().sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
            WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'') and contains(@class,'LC20lb MBeuO DKV0Md')]")));
            log.info("Test Case 01: Taking screenshot");
            if (true) {
                ScreenshotUtil screenshotUtil = new ScreenshotUtil();
                screenshotUtil.takeScreenshot(driver, "testCase01", "check");
            }
            Assert.assertTrue(firstResult.getText().contains("OpenAI"), "The first result does not contain 'OpenAI'");
            log.info("Test Case 01: Search result verified successfully");
        } catch (Exception e) {
            log.error("Test failed: {}", e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver
        DriverManager.tearDown();
    }

}
