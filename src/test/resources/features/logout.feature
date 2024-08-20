Feature: Logout

  Scenario Outline: User can logout successfully to let others to use the application
    Given user is logged in with "<username>" and "<password>" and is on the logged in homepage
    When user clicks on the burger menu
    And user clicks on the Logout button
    Then user should be logged out and others can login after this step

    Examples:
      | username            | password      |
      | standard_user       | secret_sauce  |