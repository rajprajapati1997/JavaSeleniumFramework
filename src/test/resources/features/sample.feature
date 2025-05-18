@search
Feature: Google Search Functionality
  As a user
  I want to use Google search features
  So that I can find relevant information

  Background: 
    Given I am on the Google homepage

  Scenario: Perform a basic Google search
    When I search for "Selenium WebDriver"
    Then I should see search results

  Scenario Outline: Search for different testing tools
    When I search for "<search_term>"
    Then I should see search results

    Examples:
      | search_term     |
      | Cucumber BDD    |
      | TestNG Framework|
      | Maven Testing   |

  Scenario: Verify search results contain search term
    When I search for "Automation Testing"
    Then I should see search results
    And the results should contain "Automation"
