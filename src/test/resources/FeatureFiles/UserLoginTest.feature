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

  Scenario: User logs out of their account
    Given the user is logged in
    When the user clicks on the "Logout" button
    Then the user should be logged out
    And the user should be redirected to the homepage
