Feature: Ordered list

  Scenario Outline: User can see an ordered list of the available products and can choose the order
    Given user is on the homepage already authenticated using "<browser>"
    When user chooses "<order>" order
    Then user can see the products in "<order>" order

    Examples:
      | browser  | order              |
      | firefox  | a to z             |
      #| edge     | a to z             |
      | chrome   | a to z             |
      | firefox  | z to a             |
      #| edge     | z to a             |
      | chrome   | z to a             |
      | firefox  | low to high price  |
      #| edge     | low to high price  |
      | chrome   | low to high price  |
      | firefox  | high to low price  |
      #| edge     | high to low price  |
      | chrome   | high to low price  |
