package com.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {
    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        
        // Highlight the element with a yellow background and red border
        js.executeScript(
            "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
            element
        );

        // Wait for a moment to show the highlight
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Restore original style
        js.executeScript(
            "arguments[0].setAttribute('style', arguments[1]);",
            element,
            originalStyle
        );
    }
}
