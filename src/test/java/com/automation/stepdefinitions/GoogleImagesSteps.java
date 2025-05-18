package com.automation.stepdefinitions;

import com.automation.pages.GoogleImagesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleImagesSteps {
    private final GoogleImagesPage imagesPage = new GoogleImagesPage();

    @When("I click on Images link")
    public void i_click_on_images_link() {
        imagesPage.clickImagesLink();
    }

    @Then("I should be on Google Images page")
    public void i_should_be_on_google_images_page() {
        Assert.assertTrue(imagesPage.isOnImagesPage(), "Not on Google Images page");
    }

    @Then("I should see image results")
    public void i_should_see_image_results() {
        Assert.assertTrue(imagesPage.areImageResultsDisplayed(), "Image results are not displayed");
    }

    @Then("the first image should be clickable")
    public void the_first_image_should_be_clickable() {
        Assert.assertTrue(imagesPage.isFirstImageClickable(), "First image is not clickable");
    }
}
