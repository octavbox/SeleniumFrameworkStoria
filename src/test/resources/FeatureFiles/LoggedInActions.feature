Feature: Perform tests on the buttons available to users that are logged in.

  Background:
    Given the user is logged in


  Scenario: User logs out of their account
    When the user clicks on User Menu button
    And the user clicks on Logout button
    Then the user is logged out
    And the user is redirected to the homepage


  Scenario: User can Add and Remove items from Favourites
    When the user clicks the Search button
    And the user clicks on multiple Heart buttons
    Then the selected Heart buttons are filled
    And the Favourites button counter contains the number of selected items
    When the user clicks on the Favourites dropdown
    And the Anunturi counter contains the number of selected items
    And the user clicks on the Anunturi button
    Then the Saved page appears
    And the Anunturi tab counter contains the number of selected items
    When the user clicks the Heart button on all items
    Then the Anunturi tab is empty


