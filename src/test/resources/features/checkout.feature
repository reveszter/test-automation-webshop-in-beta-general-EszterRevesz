Feature: Checkout

  Scenario Outline: User can finish an order with valid information
    Given the user is logged in and already has "<product_name_one>" and "<product_name_two>" in the shopping cart using "<browser>"
    And clicked checkout button in the shopping cart
    When the user fills out the checkout information form with valid information "<first_name>" "<last_name>" "<postal_code>"
    And completes the necessary checkout steps
    Then the user should be able to successfully complete their order

    Examples:
      | product_name_one    | product_name_two         | browser | first_name | last_name | postal_code |
      | Sauce Labs Backpack | Sauce Labs Bike Light    | firefox | James      | Smith     | 10016       |
      | Sauce Labs Backpack | Sauce Labs Bike Light    | edge    | James      | Smith     | 10016       |
      | Sauce Labs Onesie   | Sauce Labs Fleece Jacket | chrome  | Michael    | Williams  | 90068       |


  Scenario Outline: User can finish an order with the correctly calculated price
    Given the user is logged in and already has "<product_name_one>" and "<product_name_two>" in the shopping cart using "<browser>"
    When the user fills out the checkout information form with the following information "<first_name>" "<last_name>" "<postal_code>"
    Then the overview displayed the correct prices "<item_total>" "<tax>" "<total>" are shown

    Examples:
      | product_name_one    | product_name_two         | browser | first_name | last_name | postal_code | item_total | tax  | total |
      | Sauce Labs Backpack | Sauce Labs Bike Light    | firefox | James      | Smith     | 10016       | 39.98      | 3.20 | 43.18 |
      | Sauce Labs Backpack | Sauce Labs Bike Light    | edge    | James      | Smith     | 10016       | 39.98      | 3.20 | 43.18 |
      | Sauce Labs Backpack | Sauce Labs Bike Light    | chrome  | James      | Smith     | 10016       | 39.98      | 3.20 | 43.18 |


