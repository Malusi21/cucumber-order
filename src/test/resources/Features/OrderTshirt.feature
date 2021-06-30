# Author: Malusi Msomi
  # Date: 28 June 2021
  # Description:

@OrderTshirt
Feature: Feature to test the Ordering of a t-shirt
  Scenario: Login and complete a purchase with an existing user
    Given the user opens the browser to the ordering site
    And is redirected to the home page
    And Login with existing account
    When The T-Shirt category Tab is Displayed and can be clicked
    Then the user is redirected to the T-Shirt category page
    And Products are displayed to the user
    Then Hovering over a Product Reveals the item add to cart button
    And User is able to click on the Add to Cart button
    Then Click on the Proceed to Checkout button
    Then Verify the user is redirected to the Shopping-Cart Summary page
    And Preview Entered user address
    Then Confirm Shipping
    And Complete Payment via bank
    Then Confirm Order
    And Return User to Home Page



  Scenario: Login and update user firstname details
    Given the user opens the browser to the ordering site
    And is redirected to the home page
    And Login with existing account
    Then Go to User Personal information page
    And Update Users Firstname
    And Update User password
    Then Validate user details have been updated
    And New name is displayed to the user on the home page
