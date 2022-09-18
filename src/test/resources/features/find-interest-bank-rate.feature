Feature: Find interest bank rate
  Scenario Outline: Find interest bank rate
    Given Load data for test
    When I find best rate for pairCurrency '<pair_currency>' on tradeAction '<trade_action>'
    Then I should find bankRate with best rate <rate>

    Examples:
      | pair_currency | trade_action | rate   |
      | EURUSD        | SELL         | 1.0058 |

