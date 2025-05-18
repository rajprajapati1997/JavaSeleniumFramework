package com.automation.stepdefinitions;

import com.automation.pages.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleSearchSteps {
    private final GooglePage googlePage = new GooglePage();

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {
        googlePage.navigateToGoogle();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        googlePage.searchFor(searchTerm);
    }

    @Then("I should see search results")
    public void iShouldSeeSearchResults() {
        Assert.assertTrue(googlePage.areSearchResultsDisplayed(), "Search results are not displayed");
    }

    @Then("the results should contain {string}")
    public void theResultsShouldContain(String expectedText) {
        Assert.assertTrue(googlePage.searchResultsContain(expectedText), 
            "Search results do not contain the expected text: " + expectedText);
    }
}
