Feature: User Login

  Scenario Outline: User can log in with valid credentials
    Given the user is on the login page using "<browser>"
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks on the login button
    Then the user should be redirected to the homepage
    And the user should have access to features that require identification

    Examples:
      | browser  |
      | firefox  |
      | chrome   |
      #| edge     |
