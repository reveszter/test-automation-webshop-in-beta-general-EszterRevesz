Feature: Logout

  Scenario: User can logout successfully to let others to use the application
    Given user is logged in and is on the logged in homepage
    When user clicks on the burger menu
    And user clicks on the Logout button
    Then user should be logged out and others can login after this step