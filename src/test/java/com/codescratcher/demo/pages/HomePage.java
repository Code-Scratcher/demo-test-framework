package com.codescratcher.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    protected WebDriver driver;

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    private WebElement searchBox;

    // Constructor to initialize elements with PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this); // This initializes all @FindBy elements
    }

    public WebElement getSearchBoxWebElement() {
        return searchBox;
    }
}