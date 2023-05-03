Feature: WebElements
  @prices
  Scenario: Testing web elements
    Given user is logged in  on "Products" page
    And user gets all prices
    And user gets all item names
