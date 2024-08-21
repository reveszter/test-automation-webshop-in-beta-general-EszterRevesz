Feature: Ordered list

  Scenario: user can see an ordered list of the available products and can choose from them
    Given user is on the homepage already authenticated
    When user can choose of the order of the list
    And user can click on any product
    Then user will land on the chosen product detail page