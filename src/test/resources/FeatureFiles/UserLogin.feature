Feature: User Login

  Background:
    Given Storia main page is visible

  Scenario: User logs in with valid credentials
    When the user is on the login page
    And the user enters valid login credentials
    And the user submits the login form
    Then the user should be logged in

  Scenario: User logs in with invalid credentials
    When the user is on the login page
    And the user enters invalid login credentials
    And the user submits the login form
    Then the user should see an error message
    And the user should remain on the login page