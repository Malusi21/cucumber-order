# Author: Malusi Msomi
  # Date: 28 June 2021
  # Description:The following User Scenarios are bases off a online shopping store, the user details used are that of an already existing user
  #    The data / variables for this test is predefined in the Test steps class in the project
  #    the following is required when running the project: 
1. Update / swap around the Password values - This is to allow you to re-run the test after the test has updated the password
2. Ensure you have the correct version of chrome webdriverT

the following User Scenarios are bases off a online shopping store, the user details used are that of an already existing user
The data / variables for this test is predefined in the Test steps class in the project
the following is required when running the project:
1. Update / swap around the Password values - This is to allow you to re-run the test after the test has updated the password
2. Ensure you have the correct version of chrome webdriver

Scenario 1 - the following is a representation of the tests that run in this scenario: Login and complete a purchase with an existing user
    an already existing user opens the browser and loads site
    the user then clicks on the "Sign in" button
    the user that logs in with the  provided user details
    after logging in the user clicks on the T-shirts category
    on clicking the T-shirts category user is redirected to the category page and displayed products in the category
    the user needs to hover over the list item in order to preview and click the add to cart botton
    the user then clicks on the proceed to checkout button after checking that the user has only one item added to their cart
    the user then validates that the user is on the shopping cart summary page and clicks proceed to checkout
    the user previews address data on address page and clicks on proceed to checkout
    then test confirms payment by selecting a bank wire as the payment method
    The user confirms the payment method and returns home


Scenario 2 - the following is a representation of the tests that run in this scenario: Login and update user firstname details
    an already existing user opens the browser and loads site
    the user then clicks on the "Sign in" button
    the user that logs in with the  provided user details
    the user is then redireceted to the Personal information page
    the user clicks on and gets redirected to the the Personal information page via button
    the user updates their First name and password as the password update is a required field
    after updating thier details the user is shown an message saying the detail update was successful
    then firstname is verified using the values pre-definded in the test