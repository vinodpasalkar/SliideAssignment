@login @Regression
Feature: As a user I want to log in to the app

  Background:
    Given User opens the app

  @Scenario1 @Smoke
  Scenario: User opens the android app first time and sees a login screen
    Then  login screen with user name and password and login button is displayed

  @Scenario2 # Blocked scenario - Then step is failing as there is no UI locator available for error marker
  Scenario: User login failed
    And the user provided wrong user name and password
    When login button is clicked
    Then error markers are displayed by user name and password entries

  @Scenario3
  Scenario: User login succeed
    And the user provided right user name and password
    When login button is clicked
    Then user is taken to the news screen

  @Scenario4
  Scenario: User opens app next time (when previously logged in)
    And the user is already logged in the app
    When the user opens app next time
    Then user is taken straight to the news screen