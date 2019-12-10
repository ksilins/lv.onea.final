Feature: Product selection and purchase

  @Chrome
  Scenario: Selecting a product and proceeding to checkout
    Given I open onea.lv site
    And I search for: Spēļu konsoles
    And choose Sony product with most stars
    And open item number 3
    When I add item and go to cart
    And proceed to check out unregistered
    And choose to get item in office
    And choose to pay with cash
    Then order data is correct

