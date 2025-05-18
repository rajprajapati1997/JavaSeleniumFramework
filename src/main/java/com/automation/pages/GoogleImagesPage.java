package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleImagesPage extends BasePage {
    private final By imagesLink = By.linkText("Images");
    private final By imageResults = By.cssSelector("div[data-ri]");
    private final By firstImage = By.cssSelector("div[data-ri='0']");

    public void clickImagesLink() {
        click(imagesLink);
    }

    public boolean isOnImagesPage() {
        return driver.getCurrentUrl().contains("tbm=isch");
    }

    public boolean areImageResultsDisplayed() {
        return isElementDisplayed(imageResults);
    }

    public boolean isFirstImageClickable() {
        try {
            WebElement image = waitForElement(firstImage);
            return image != null && image.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
