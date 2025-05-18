package com.automation.stepdefinitions;

import com.automation.pages.GoogleAdvancedSearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleAdvancedSearchSteps {
    private final GoogleAdvancedSearchPage advancedSearchPage = new GoogleAdvancedSearchPage();

    @Then("all results should be PDF files")
    public void all_results_should_be_pdf_files() {
        Assert.assertTrue(advancedSearchPage.allResultsArePDFFiles(), 
            "Not all results are PDF files");
    }

    @When("I filter results for past week")
    public void i_filter_results_for_past_week() {
        advancedSearchPage.filterByPastWeek();
    }

    @Then("all results should be from last week")
    public void all_results_should_be_from_last_week() {
        Assert.assertTrue(advancedSearchPage.areResultsFromLastWeek(), 
            "Not all results are from last week");
    }

    @Then("I should see no results message")
    public void i_should_see_no_results_message() {
        Assert.assertTrue(advancedSearchPage.isNoResultsMessageDisplayed(), 
            "No results message is not displayed");
    }
}
