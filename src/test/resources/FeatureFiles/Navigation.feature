Feature: Perform general navigation tests. Try out various Selenium capabilities.
#  Open second tab, switch between tabs, go back, refresh
#  Upload a file, open two browser windows and perform actions on both


  Scenario: Add an item to Favourites and unfavourite it on a second tab
    Given the user is logged in
    When the user clicks the Search button
    And the user clicks on multiple Heart buttons
    And the user returns to the previous page
    And Storia main page is visible

    And the user opens a new tab
    And the user switches to second tab
    And the user navigates to Storia main page
    And the user clicks on the Favourites dropdown
    And the Anunturi counter contains the number of selected items
    And the user clicks on the Anunturi button
    And the user clicks the Heart button on all items
    Then the Anunturi tab is empty

    When the user switches to first tab
    And the user refreshes the page
    And the user clicks on the Favourites dropdown
    And the Anunturi counter is not visible
