Feature: Create order
  Scenario Outline: Create order and save to database
    Given I create order with idCustomer <id_customer>, pairCurrency '<pairCurrency>', tradeAction '<tradeAction>', amount <amount> and store to database
    When I search that orders
    Then I should find result order

    Examples:
      | id_customer | pairCurrency | tradeAction | amount |
      |      1     |    EURUSD    |     SELL    | 1000.0 |