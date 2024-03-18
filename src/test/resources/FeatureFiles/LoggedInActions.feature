Feature: Logged In Actions

  Background:
    Given the user is logged in

  Scenario: User logs out of their account
    When the user clicks on User Menu button
    And the user clicks on Logout button
    Then the user should be logged out
    And the user should be redirected to the homepage