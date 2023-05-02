@regression @login
Feature: Item purchase
  @wip
  Scenario: Successful item purchase
    Given user is logged in  on "Products" page
    When user adds "backpack" to the cart
    And user clicks on "Cart"
    Then user sees the "right price" for the "item"
    And user clicks on "checkout"
    Then user is on "Checkout: Your Information" page
    And user enters "name"
    And user enters "surname"
    And user enters "postcode"
    And user clicks continue
    Then user is on "Overview" page
    When user clicks on "Finish"
    Then user is on "Complete" page
