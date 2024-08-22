Feature: Show Product
  As a logged in user
  I want to see every product o it's own page
  So that I can get detailed information on the product

  Scenario Outline: Successful check of product details
    Given User is logged in on the homepage using "<browser>"
    When User select an item by clicking
    Then Details of the selected product can be seen on the screen

    Examples:
      | browser  |
      | firefox  |
      | chrome   |
      | edge     |
