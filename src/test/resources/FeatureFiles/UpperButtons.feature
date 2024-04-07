Feature: Check links of dropdown buttons in upper part of main page

  Background:
    Given Storia main page is visible

    #DE VANZARE

  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<propertyType>" button under PROPRIETĂȚI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<propertyType>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    Examples:
      | dropDownName | propertyType     | transactionType | city |
#      | De Vanzare   | Case              | De vânzare      |      |
#      | De Vanzare   | Garsoniere   | De vânzare      |      |
#      | De Vanzare   | Apartamente       | De vânzare      |      |
#      | De Vanzare   | Terenuri          | De vânzare      |      |
#      | De Vanzare   | Spații comerciale | De vânzare      |      |
      | De Vanzare   | Birouri          | De vânzare      |      |
      | De Vanzare   | Hale și depozite | De vânzare      |      |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<city>" button under LOCAȚII POPULARE
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<city>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    # Iasi is bugged, html text is "Iași ".
    # Cluj-Napoca is bugged, page title contains "Cluj-napoca".
    Examples:
      | dropDownName | propertyType | transactionType | city   |
#      | De Vanzare   | Apartamente  | De vânzare      | București   |
#      | De Vanzare   | Apartamente  | De vânzare      | Iași        |
#      | De Vanzare   | Apartamente  | De vânzare      | Cluj-Napoca |
#      | De Vanzare   | Apartamente  | De vânzare      | Timișoara   |
#      | De Vanzare   | Apartamente  | De vânzare      | Constanța |
#      | De Vanzare   | Apartamente  | De vânzare      | Craiova     |
      | De Vanzare   | Apartamente  | De vânzare      | Brașov |
      | De Vanzare   | Apartamente  | De vânzare      | Galați |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <blogPost> button under GHIDUL CUMPĂRĂTORULUI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<blogPost>" item
    Then the webpage title contains "<blogPost>"

#    All blog posts have differences between the button text and the post page title
    Examples:
      | dropDownName | blogPost                 |
#      | De Vanzare   | Diferența dintre suprafața construită |
      | De Vanzare   | Apartament în bloc vechi |
      | De Vanzare   | Locuințele la parter     |
#
#
#
#   DE INCHIRIAT

  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<propertyType>" button under PROPRIETĂȚI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<propertyType>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    Examples:
      | dropDownName | propertyType | transactionType | city |
      | De Inchiriat | Case         | De închiriat    |      |
      | De Inchiriat | Garsoniere   | De închiriat    |      |
#      | De Inchiriat | Apartamente       | De închiriat    |      |
#      | De Inchiriat | Terenuri          | De închiriat    |      |
#      | De Inchiriat | Spații comerciale | De închiriat    |      |
#      | De Inchiriat | Birouri           | De închiriat    |      |
#      | De Inchiriat | Hale și depozite  | De închiriat    |      |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<city>" button under LOCAȚII POPULARE
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<city>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    # Iasi is bugged, html text is "Iași ".
    # Cluj-Napoca is bugged, page title contains "Cluj-napoca".
    Examples:
      | dropDownName | propertyType | transactionType | city   |
#      | De Inchiriat | Apartamente  | De închiriat    | București   |
#      | De Inchiriat | Apartamente  | De închiriat    | Iași        |
#      | De Inchiriat | Apartamente  | De închiriat    | Cluj-Napoca |
#      | De Inchiriat | Apartamente  | De închiriat    | Timișoara   |
#      | De Inchiriat | Apartamente  | De închiriat    | Constanța   |
#      | De Inchiriat | Apartamente  | De închiriat    | Craiova     |
      | De Inchiriat | Apartamente  | De închiriat    | Brașov |
      | De Inchiriat | Apartamente  | De închiriat    | Galați |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <agency> button under AGENȚII IMOBILIARE POPULARE
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<agency>" item
    Then the webpage title contains "<pageTitle>"

#    Agenții imobiliare - București link leads to Dezvoltatori imobiliari recomandati - Bucuresti
#    Agenții imobiliare - Craiova link leads to Agentii imobiliare recomandate din Romania
    Examples:
      | dropDownName | agency                      | pageTitle                               |
#      | De Inchiriat | Agenții imobiliare - București   | Agenții imobiliare recomandate - Bucuresti   |
#      | De Inchiriat | Agenții imobiliare - Iași        | Agenții imobiliare recomandate - Iasi        |
#      | De Inchiriat | Agenții imobiliare - Cluj-Napoca | Agenții imobiliare recomandate - Cluj-Napoca |
#      | De Inchiriat | Agenții imobiliare - Timișoara   | Agenții imobiliare recomandate - Timișoara   |
#      | De Inchiriat | Agenții imobiliare - Constanța   | Agenții imobiliare recomandate - Constanța   |
#      | De Inchiriat | Agenții imobiliare - Craiova     | Agenții imobiliare recomandate - Craiova     |
      | De Inchiriat | Agenții imobiliare - Brașov | Agenții imobiliare recomandate - Brașov |
      | De Inchiriat | Agenții imobiliare - Galați | Agenții imobiliare recomandate - Galați |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <blogPost> button under GHIDUL CHIRIAȘULUI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<blogPost>" item
    Then the webpage title contains "<blogPost>"

#    All blog posts have differences between the button text and the post page title
    Examples:
      | dropDownName | blogPost               |
#      | De Inchiriat | Garanția la contractul de închiriere |
#      | De Inchiriat | închiriezi un apartament             |
      | De Inchiriat | Drepturile chiriașului |
#
#
#
#   ANSAMBLURI REZIDENTIALE

  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<propertyType>" button under PROPRIETĂȚI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<propertyType>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    Examples:
      | dropDownName            | propertyType | transactionType | city |
      | Ansambluri Rezidentiale | Apartamente  | De vânzare      |      |
      | Ansambluri Rezidentiale | Case         | De vânzare      |      |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the "<city>" button under LOCAȚII POPULARE
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<city>" item
    Then the search results page title contains "<propertyType>" "<transactionType>" "<city>"
    And the search results match the search criteria "<propertyType>" "<transactionType>" "<city>"

    # Iasi is bugged, html text is "Iași ".
    Examples:
      | dropDownName            | propertyType   | transactionType | city      |
      | Ansambluri Rezidentiale | Ansambluri noi | De vânzare      | București |
      | Ansambluri Rezidentiale | Ansambluri noi | De vânzare      | Iași      |
      | Ansambluri Rezidentiale | Ansambluri noi | De vânzare      | Constanța |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <realEstateDev> button under AGENȚII IMOBILIARE POPULARE
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<realEstateDev>" item
    Then the webpage title contains "<pageTitle>"

    Examples:
      | dropDownName            | realEstateDev              | pageTitle                                         |
      | Ansambluri Rezidentiale | Dezvoltatori - București   | Dezvoltatori imobiliari recomandati - Bucuresti   |
      | Ansambluri Rezidentiale | Dezvoltatori - Iași        | Dezvoltatori imobiliari recomandati - Iasi        |
      | Ansambluri Rezidentiale | Dezvoltatori - Cluj-Napoca | Dezvoltatori imobiliari recomandati - Cluj-Napoca |
#      | Ansambluri Rezidentiale | Dezvoltatori - Timișoara   | Dezvoltatori imobiliari recomandati - Timișoara   |
#      | Ansambluri Rezidentiale | Dezvoltatori - Constanța   | Dezvoltatori imobiliari recomandati - Constanța   |
#      | Ansambluri Rezidentiale | Dezvoltatori - Craiova     | Dezvoltatori imobiliari recomandati - Craiova     |
#      | Ansambluri Rezidentiale | Dezvoltatori - Brașov      | Dezvoltatori imobiliari recomandati - Brașov      |
#      | Ansambluri Rezidentiale | Dezvoltatori - Galați      | Dezvoltatori imobiliari recomandati - Galați      |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <blogPost> button under GHIDUL CUMPĂRĂTORULUI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<blogPost>" item
    Then the webpage title contains "<blogPost>"

#    All blog posts have differences between the button text and the post page title
    Examples:
      | dropDownName            | blogPost                         |
      | Ansambluri Rezidentiale | Bloc monolit vs bloc prefabricat |
      | Ansambluri Rezidentiale | Rate la dezvoltator              |
      | Ansambluri Rezidentiale | La ce să fiu atent când cumpăr   |
#
#
#
#   COMPANII

  Scenario Outline: User clicks "<dropDownName>" dropdown then the <companyType> button under GHIDUL CUMPĂRĂTORULUI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<companyType>" item
    Then the webpage title contains "<companyType>"

    Examples:
      | dropDownName | companyType        |
#      | Companii     | Agenții imobiliare |
      | Companii     | Dezvoltatori       |


  Scenario Outline: User clicks "<dropDownName>" dropdown then the <blogPost> button under GHIDUL CUMPĂRĂTORULUI
    When the user clicks on "<dropDownName>" dropdown from upper buttons
    And the user clicks the "<blogPost>" item
    Then the webpage title contains "<blogPost>"

#    All blog posts have differences between the button text and the post page title
    Examples:
      | dropDownName | blogPost                                  |
      | Companii     | 7 tehnici de negociere                    |
      | Companii     | Contract de exclusivitate pentru vânzarea |
      | Companii     | Vânzarea unui imobil în construcție       |