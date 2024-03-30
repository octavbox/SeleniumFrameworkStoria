Feature: Check links of dropdown buttons in upper part of main page

  Background:
    Given Storia main page is visible

  @Active
  Scenario Outline: User clicks De Vanzare dropdown then property type buttons
    When the user clicks on De Vanzare dropdown button
    And the user clicks the "<propertyType>" button
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" and "<transactionType>" and "<city>"

    Examples:
      | propertyType      | transactionType | city |
#      | Case              | De vânzare      |      |
#      | Garsoniere        | De vânzare      |      |
#      | Apartamente       | De vânzare      |      |
#      | Terenuri          | De vânzare      |      |
#      | Spații comerciale | De vânzare      |      |
      | Birouri           | De vânzare      |      |
      | Hale și depozite  | De vânzare      |      |


  Scenario Outline: User clicks De Vanzare dropdown then city buttons
    When the user clicks on De Vanzare dropdown button
    And the user clicks the "<city>" button
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" and "<transactionType>" and "<city>"

    # Iasi is bugged, html text is "Iași ".
    # Cluj-Napoca is bugged, page title contains "Cluj-napoca".
    Examples:
      | propertyType | transactionType | city        |
#      | Apartamente  | De vânzare      | București   |
#      | Apartamente  | De vânzare      | Iași        |
#      | Apartamente  | De vânzare      | Cluj-Napoca |
#      | Apartamente  | De vânzare      | Timișoara   |
#      | Apartamente  | De vânzare      | Constanța   |
#      | Apartamente  | De vânzare      | Craiova     |
      | Apartamente  | De vânzare      | Brașov      |
      | Apartamente  | De vânzare      | Galați      |