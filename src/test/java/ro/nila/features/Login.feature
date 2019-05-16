Feature: Login Functionality
  In order to perform successful login
  As a User
  I want to enter correct username and password

  Background:
    Given user navigate to application url
    When user validates the homepage page

  Scenario: Verify elements from Login Page
    And user go to Login Page
    Then user validate the Login Page
    Then user verify all elements from Login Page

  Scenario Outline: Verify the login functionality
    And user go to Login Page
    When user validate the Login Page
    Then user enter "<username>" username
    And user enter "<password>" password
    And user click on Sign In button
    Then user should "<loginType>" successfully logged in

    Examples:
      | username               | password | loginType |
      | radualinpopa@yahoo.com | invalid  | not       |
      | example                | asd123   | not       |
      | invalid                | invalid  | not       |
      | radualinpopa@yahoo.com | asd123   | be        |
