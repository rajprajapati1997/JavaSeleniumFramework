package com.automation.pages;

import com.automation.config.WebDriverConfig;
import com.automation.utils.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverConfig.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        HighlightElement.flash(element, driver);
        return element;
    }

    protected WebElement waitForClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        HighlightElement.flash(element, driver);
        return element;
    }

    protected void click(By locator) {
        WebElement element = waitForClickable(locator);
        HighlightElement.flash(element, driver);
        element.click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        HighlightElement.flash(element, driver);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        WebElement element = waitForElement(locator);
        HighlightElement.flash(element, driver);
        return element.getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForElement(locator);
            HighlightElement.flash(element, driver);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
