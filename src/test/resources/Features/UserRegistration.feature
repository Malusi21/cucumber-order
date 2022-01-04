# Author: Malusi Msomi
  # Date: 17 November 2021
  # Description:The following User Scenarios are bases off a online shopping store, the user is instructed to do.
  #    this test feature file executes the following:
  #    - User details input to registration page
  #    - User registration complete check/validation and submit
  #    The data / variables for this test is predefined in the Test steps class in this project

  @Registration
  Feature: User Online Registration
  #  The following feature outlines th test cases and test scenarios that are related to the online registration
  #  conducted on a online ordering store
    Rule : User account does not exist
      Background:
        Given The user enters an already existing email
    # user needs to scroll to the top of the registration form
    # find create an account string, Validate the correct url, Validate the form title, scroll and validate register button
    # Click register button, scroll to the top and verify validation message


      Scenario Outline:
        Given the user enters their <username> and clicks create
        And Error message is displayed on clicking create
        When tries logging in with a <username> and <password>
        Then the user is presented with the correct error message

        Examples:
          | username     | password     |
          | "MmsomiUser" | "Test!@12"   |
          | "Legendtest" | "Legend@@12" |
          | "Mmsomi1"    | "Test!@12"   |
          | "Legend30"   | "Legend@@12" |

    Rule : User account does exist
      Background:
        Given The user enters an already existing email
    # user enters their email address
    # verify that an already existing user is displayed with the correct
     # Given The user enters a brand new email

        Scenario Outline:
          Given the user already does exists
          When the user enters their <username> and <password>
          Then the user clicks the login button
          And the user is shown their <firstname> and <lastname> on the account page

          Examples:
            | username           | password | firstname     | lastname |
            | Test@1222email.com | 12345    | Spanishlaliga | TetSur   |