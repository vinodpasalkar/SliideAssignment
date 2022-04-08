@News @Regression
Feature: As a user I want to see my news

  Background:
    Given User opens the app

  @Scenario5 @Smoke
  Scenario: News images are loaded successfully
    Given the user is already logged in the app
    When there is internet connection
    Then images are displayed in the rows on the list

  @Scenario6
  Scenario: Failed to load news images
    Given the user is already logged in the app with no internet connection
    Then failed to load news error message is displayed and Retry button

  @Scenario7 @Smoke
  Scenario: News image is clicked successfully
    Given there is internet connection
    And the user is already logged in the app
    And the news images are successfully loaded on the screen
    When the user clicks one of the image
    Then user is navigated to the external browser with clicked image loaded