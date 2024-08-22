Feature: Ordered list

  Background:
    Given user is on the homepage already authenticated

  Scenario Outline: User can see an ordered list of the available products and can choose the order
    When user chooses "<order>" order
    Then user can see the products in "<order>" order

    Examples:
      | order              |
      | a to z             |
      | z to a             |
      | low to high price  |
      | high to low price  |
