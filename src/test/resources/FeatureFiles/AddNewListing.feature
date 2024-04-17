Feature: Test the ability to add new listings

  @Active
  Scenario Outline: Add a new listing
    Given the user is logged in
    When the user clicks the Adauga Anunt button
    Then the Adauga Anunt page appears
    When the user clicks the Voi Vinde button
    And the user clicks on the Apartaments rectangle
    And the user clicks on the Continua button
    Then the Adaugare Descriere page appears
    When the user uploads a file to upload space number "<firstIndex>"
    And the user enters "<firstFilePath>" and presses Open in the pop-up page
    And the user uploads a file to upload space number "<secondIndex>"
    And the user enters "<secondFilePath>" and presses Open in the pop-up page
#    Then the uploaded files are visible in the upload spaces
#    When the user switches the position of the uploaded files
#    Then the uploaded photos positions are switched

    Examples:
      | firstIndex | firstFilePath                      | secondIndex | secondFilePath                    |
      | 1          | \src\test\resources\Photos\cats.jpg | 19           | \src\test\resources\Photos\dog.jpg |
