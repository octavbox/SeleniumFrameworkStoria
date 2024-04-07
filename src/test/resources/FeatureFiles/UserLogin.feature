
Feature: User Login
  Background:
    Given Storia main page is visible


  Scenario: User logs in with valid credentials
    When the user clicks on the Contul Meu button
    And the user enters valid login credentials
    Then the password is hidden
    When the user clicks the Eye button
    Then the password is visible
    When the user clicks the Eye button
    Then the password is hidden
    When the user clicks the Autentificare button
    Then the user should be logged in


  Scenario: User logs in with invalid credentials
    When the user clicks on the Contul Meu button
    And the user enters invalid login credentials
    And the user clicks the Autentificare button
    Then the user should see an error message
    And the user should remain on the login page