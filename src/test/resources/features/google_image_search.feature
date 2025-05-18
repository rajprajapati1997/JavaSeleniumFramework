@image
Feature: Google Image Search
  As a user
  I want to search for images on Google
  So that I can find relevant images

  Background: 
    Given I am on the Google homepage

  Scenario: Navigate to Google Images
    When I click on Images link
    Then I should be on Google Images page

  Scenario Outline: Search for different image categories
    When I click on Images link
    And I search for "<search_term>"
    Then I should see image results
    And the first image should be clickable

    Examples:
      | search_term    |
      | cute puppies   |
      | scenic beaches |
