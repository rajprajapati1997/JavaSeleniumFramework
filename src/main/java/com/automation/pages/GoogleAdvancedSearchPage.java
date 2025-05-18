package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GoogleAdvancedSearchPage extends BasePage {
    private final By pdfResults = By.cssSelector("div.g div.VwiC3b");
    private final By toolsButton = By.cssSelector("div[aria-label='Search tools']");
    private final By timeDropdown = By.cssSelector("div[aria-label='Time'] span");
    private final By pastWeekOption = By.xpath("//div[@role='menuitem'][contains(., 'Past week')]");
    private final By noResultsMessage = By.cssSelector("div.card-section p:first-of-type");
    
    public boolean allResultsArePDFFiles() {
        try {
            List<WebElement> results = driver.findElements(pdfResults);
            return results.stream()
                .map(WebElement::getText)
                .allMatch(text -> text.toLowerCase().contains(".pdf"));
        } catch (Exception e) {
            return false;
        }
    }

    public void filterByPastWeek() {
        click(toolsButton);
        click(timeDropdown);
        click(pastWeekOption);
    }

    public boolean areResultsFromLastWeek() {
        // This is a simplified check. In a real implementation,
        // you would parse dates from search results and verify them
        return driver.getCurrentUrl().contains("qdr=w");
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            WebElement message = waitForElement(noResultsMessage);
            return message.getText().contains("did not match any documents");
        } catch (Exception e) {
            return false;
        }
    }
}
