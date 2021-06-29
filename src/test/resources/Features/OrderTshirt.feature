# Author: Malusi Msomi
  # Date: 28 June 2021
  # Description:

Feature: feature to test the Ordering of a t-shirt

  Scenario: Check that user is taken to the correct page to purchase
    Given the user opens the browser to the ordering site
    And is redirected to the home page
    When The user is Displayed the "T-Shirt" category Tab
    And Click on the T-Shirt Category button
    Then the user is redirected to the "T-Shirt" category page
