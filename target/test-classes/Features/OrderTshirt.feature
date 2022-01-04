# Author: Malusi Msomi
  # Date: 28 June 2021
  # Description:The following User Scenarios are bases off a online shopping store, the user details used are that of an already existing user
  #    The data / variables for this test is predefined in the Test steps class in the project
  #    the following is required when running the project:
  #    1. Update / swap around the Password values - This is to allow you to re-run the test after the test has updated the password
  #    2. Ensure you have the correct version of chrome webdriver

@OrderTshirt
Feature: Feature to test the Ordering of a t-shirt
  Background: New browser session for ordering T-shirts
    # set of steps that will run prior to any scenarios running
    # given a user is on the ordering site and the user is not logged in
    Given the user opens the browser to the ordering site
    When The Br+-owser has loaded
    Then the user should be on the correct Ordering site page
    And The user is not logged in

  Scenario Outline: Login with user details
    # Set of steps that will run and take in the values that are displayed in the
    Given user is redirected to the home page
    And the user clicks on the Login button
    When the user is redirected to the login page and logins with a <username> and <password> of an existing account
    And the user
    Then the user should be successfully logged in
    And Correct <username> is displayed

  Scenario: Select a item to purchase from the T-shirt Category
    Given the user should be successfully logged in
    And user clicks on the T-shirt category button
    When the user is redirected to the category page
    And  the user is shown the list of category items to chose from
    Then user Hovers over a Product Reveals the item add to cart button
    And user clicks on the

  #Scenario:




  #Scenario: Update user details

  Examples:
    | username | password |
    | "MmsomiUser" | "Test!@12"   |
    | "Legendtest" | "Legend@@12" |
    | "Mmsomi1"    | "Test!@12"   |
    | "Legend30"   | "Legend@@12" |


  Scenario: Login and complete a purchase with an existing user
    Given the user opens the browser to the ordering site
    And is redirected to the home page
    And Login with existing account
    When The T-Shirt category Tab is Displayed and can be clicked -

 # (Contextual Info - this can be added to the Context
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
