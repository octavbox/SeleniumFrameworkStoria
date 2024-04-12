Feature: Perform positive and negative tests on the user login feature.

  Background:
    Given Storia main page is visible


  Scenario: User enters valid credentials
    When the user clicks on the Contul Meu button
    And the user enters valid login credentials
    Then the password is hidden
    When the user clicks the Eye button
    Then the password is visible
    When the user clicks the Eye button
    Then the password is hidden
    When the user clicks the Autentificare button
    Then the user should be logged in


  Scenario Outline: User enters invalid credentials. Email: "<email>". Password: "<password>"
    When the user clicks on the Contul Meu button
    And the user enters invalid login credentials: "<email>" and "<password>"
    And the user clicks the Autentificare button
    Then a message appears if email input ("<email>") is blank
    And a message appears if password input ("<password>") is blank
    And an error message appears if "<email>" and "<password>" are not blank
    And the user should remain on the login page

    Examples:
      | email                       | password  |
      |                             | Qwerty11! |
      | octavian.testwork@gmail.com |           |
      | @gmail.com                  | Qwerty11! |
      | octavian.testwork           | Qwerty11! |