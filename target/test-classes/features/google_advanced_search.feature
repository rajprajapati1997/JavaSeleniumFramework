@advanced
Feature: Google Advanced Search
  As a user
  I want to use Google's advanced search features
  So that I can find more specific results

  Background: 
    Given I am on the Google homepage

  Scenario: Search with file type filter
    When I search for "selenium automation pdf filetype:pdf"
    Then I should see search results
    And all results should be PDF files

  Scenario: Search within specific time range
    When I search for "latest technology news"
    And I filter results for past week
    Then I should see search results
    And all results should be from last week

  Scenario: Search with invalid filters
    When I search for "!@#$%^&* filetype:invalid"
    Then I should see no results message
