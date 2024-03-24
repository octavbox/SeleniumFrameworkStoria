Feature: Logged In Actions

  Background:
    Given the user is logged in

  Scenario: User logs out of their account
    When the user clicks on User Menu button
    And the user clicks on Logout button
    Then the user should be logged out
    And the user should be redirected to the homepage

    @Test
  Scenario: User can Add and Remove items from Favourites
    When the user clicks the Search button
    And the search results page appears
    And the user clicks on multiple Heart buttons
    Then the selected Heart buttons are filled
    And the Favourites button counter contains the number of selected items
    When the user clicks on the Favourites dropdown
    And the Anunturi counter contains the number of selected items
    And the user clicks on the Anunturi button
    Then the Saved page appears
    And the Anunturi tab counter contains the number of selected items
    When the user clicks all the Heart buttons
    Then the Anunturi tab counter contains zero items


