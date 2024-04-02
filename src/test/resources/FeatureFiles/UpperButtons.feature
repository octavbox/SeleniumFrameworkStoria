Feature: Check links of dropdown buttons in upper part of main page

  Background:
    Given Storia main page is visible

    #   DE VANZARE
  @Active
  Scenario Outline: User clicks De Vanzare dropdown then the "<propertyType>" button under PROPRIETĂȚI
    When the user clicks on De Vanzare dropdown button
    And the user clicks the "<propertyType>" button of De Vanzare
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" and "<transactionType>" and "<city>"

    Examples:
      | propertyType     | transactionType | city |
#      | Case              | De vânzare      |      |
#      | Garsoniere        | De vânzare      |      |
#      | Apartamente       | De vânzare      |      |
#      | Terenuri          | De vânzare      |      |
#      | Spații comerciale | De vânzare      |      |
      | Birouri          | De vânzare      |      |
      | Hale și depozite | De vânzare      |      |

  @Active
  Scenario Outline: User clicks De Vanzare dropdown the "<city>" button under LOCAȚII POPULARE
    When the user clicks on De Vanzare dropdown button
    And the user clicks the "<city>" button of De Vanzare
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" and "<transactionType>" and "<city>"

    # Iasi is bugged, html text is "Iași ".
    # Cluj-Napoca is bugged, page title contains "Cluj-napoca".
    Examples:
      | propertyType | transactionType | city   |
#      | Apartamente  | De vânzare      | București   |
#      | Apartamente  | De vânzare      | Iași        |
#      | Apartamente  | De vânzare      | Cluj-Napoca |
#      | Apartamente  | De vânzare      | Timișoara   |
#      | Apartamente  | De vânzare      | Constanța   |
#      | Apartamente  | De vânzare      | Craiova     |
      | Apartamente  | De vânzare      | Brașov |
      | Apartamente  | De vânzare      | Galați |

  @Active
  Scenario Outline: User clicks De Vanzare dropdown the <blogPost> button under GHIDUL CUMPĂRĂTORULUI
    When the user clicks on De Vanzare dropdown button
    And the user clicks the "<blogPost>" button of De Vanzare
    Then the blog post title contains "<blogPost>"

#    All blog posts have differences between the button text and the post page title
    Examples:
      | blogPost                              |
      | Diferența dintre suprafața construită |
#      | Apartament în bloc vechi              |
#      | Locuințele la parter                  |
#
#
#
#   DE INCHIRIAT
  @Active
  Scenario Outline: User clicks De Inchiriat dropdown then the "<propertyType>" button under PROPRIETĂȚI
    When the user clicks on De Inchiriat dropdown button
    And the user clicks the "<propertyType>" button of De Inchiriat
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" and "<transactionType>" and "<city>"

    Examples:
      | propertyType     | transactionType | city |
#      | Case              | De închiriat    |      |
#      | Garsoniere        | De închiriat    |      |
#      | Apartamente       | De închiriat    |      |
#      | Terenuri          | De închiriat    |      |
#      | Spații comerciale | De închiriat    |      |
      | Birouri          | De închiriat    |      |
      | Hale și depozite | De închiriat    |      |

  @Active
  Scenario Outline: User clicks De Inchiriat dropdown the <agency> button under AGENȚII IMOBILIARE POPULARE
    When the user clicks on De Inchiriat dropdown button
    And the user clicks the "<agency>" button of De Inchiriat
    Then the blog post title contains "<agency>"

    Examples:
      | agency                           |
      | Agenții imobiliare - București   |
#      | Agenții imobiliare - Iași        |
#      | Agenții imobiliare - Cluj-Napoca |