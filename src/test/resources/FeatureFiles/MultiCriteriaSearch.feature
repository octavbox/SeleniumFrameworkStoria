Feature:  Multi-criteria Property Search

  Background:
    Given Storia main page is visible

  @Active
  Scenario Outline: User searches for properties
    When the user selects "<propertyType>" from the property type dropdown
    And the user selects "<transactionType>" from the transaction type dropdown
    And the user selects "<radius>" from the radius dropdown
    And the user selects "<city>" from the city dropdown
    And the user enters "<priceMin>" in the lower end price field
    And the user enters "<priceMax>" in the higher end price field
    And the user enters "<areaMin>" in the lower end surface field
    And the user enters "<areaMax>" in the higher end surface field
    Then the search button contains a count of the results
    And the user clicks the Search button
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"
    And the counter number on the search button matches the number in the search results

    Examples:
      | propertyType | transactionType | city      | radius | priceMin | priceMax | areaMin | areaMax |
      | Case         | De închiriat    | Bucuresti | 5 km   | 100      | 500      |         | 100     |
      | Garsoniere   | De vânzare      | Brasov    | 5 km   |          |          | 40      |         |
      | Apartamente  | De închiriat    | Timisoara | 10 km  |          | 300      | 50      |         |
#      | Terenuri     | De vânzare      | Iasi      | 15 km  |          | 10000    |         |         |
#      | Garsoniere   | De închiriat    | Cluj      | 25 km  | 200      |          |         |         |
#      | Garaje       | De vânzare      | Constanta | 50 km  |          | 500      |         |         |
#      | Case         | De închiriat    |           | 75 km  | 2000     |          |         |         |