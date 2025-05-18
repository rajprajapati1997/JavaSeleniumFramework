package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {
    private final By searchBox = By.name("q");
    private final By searchResults = By.cssSelector("div#search");
    private final By acceptButton = By.xpath("//button[contains(., 'Accept all')]");
    private final By searchResultsText = By.cssSelector("div#search h3, div#search .VwiC3b");

    public void navigateToGoogle() {
        driver.get("https://www.google.com");
        try {
            if (isElementDisplayed(acceptButton)) {
                click(acceptButton);
            }
        } catch (Exception e) {
            // Cookie consent might not appear in all regions
        }
    }

    public void searchFor(String searchTerm) {
        type(searchBox, searchTerm);
        waitForElement(searchBox).sendKeys(Keys.ENTER);
        // Wait for URL to change, indicating search is complete
        wait.until(driver -> driver.getCurrentUrl().contains("search"));
    }

    public boolean areSearchResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean searchResultsContain(String expectedText) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultsText));
            List<WebElement> resultElements = driver.findElements(searchResultsText);
            return resultElements.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.toLowerCase().contains(expectedText.toLowerCase()));
        } catch (Exception e) {
            return false;
        }
    }
}
