Feature: Shopping Cart

  Scenario Outline: User can add an item to the shopping cart
    Given the user successfully logged in "<browser>"
    And is currently on the page where he sees the products
    When he clicks on the "<product_name>" product's 'Add to cart' button
    And opens the shopping cart
    Then the user should be able to see the selected product "<product_name>" in the cart

    Examples:
      | browser  | product_name        |
      | firefox  | Sauce Labs Backpack |
      | chrome   | Sauce Labs Onesie   |
      | edge     | Sauce Labs Backpack |


  Scenario Outline: User can remove product from the shopping cart
    Given the user successfully logged in
    And already has "<product_name>" in the shopping cart
    When he opens the shopping cart by clicking on it
    And clicks on the 'Remove' button of "<product_name>"
    Then the product should disappear from the shopping cart

    Examples:
      | product_name             |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
