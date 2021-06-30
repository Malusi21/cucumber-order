# Author: Malusi Msomi
  # Date: 28 June 2021
  # Description:

@OrderTshirt
Feature: Feature to test the Ordering of a t-shirt
  Scenario: Check that user is taken to the correct page to purchase
    Given the user opens the browser to the ordering site
    And is redirected to the home page
    When The T-Shirt category Tab is Displayed and can be clicked
    Then the user is redirected to the T-Shirt category page
    And Products are displayed to the user
    Then Hovering over a Product Reveals the item add to cart button
    And User is able to click on the Add to Cart button
    Then Click on the Proceed to Checkout button
    Then Verify the user is redirected to the Shopping-Cart Summary page
    And Signin With a default user account on Authentication page
    Then Click on the Create an account button
    And Create a new user account by adding in Personal details
    And Enter user address
    Then Click on the Register button



  Scenario:
    Then Click on the "Proceed to Checkout" button
    And Verify that the correct email address and agree to terms on shipping page
    Then Click on the "Proceed to Checkout" button
    And Verify the correct amount is displayed in the payment screen
    Then Select Bank payment option
    And Verify user is redirected to the Bank-Wire payment page
    Then Click on the "I confirm my order" button
    And Verify that the user is presented with their order details
    Then Click "Back to Orders button"
    And Validate the correct Order details are displayed in the Order history
    Then Click on the "Home" button
    And Validate that the user is redirected to the home page