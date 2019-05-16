Feature: Registration Functionality
  In order to perform successful registration
  As a User
  I want to provide a valid email and password

  Background:
    Given user navigate to application url
    When user validates the homepage page

  Scenario: Verify elements from Registration Page
    And user go to Registration Page
    And user validate the Registration Page
    Then user verify all elements from Registration Page

  Scenario Outline: Verify the registration functionality
    And user go to Registration Page
    When user validate the Registration Page
    And user enter "<mail>" username
    And user enter "<password>" password
    And user click on Sign Up button
    Then user should "<registerType>" successfully register

    Examples:
      | mail             | password    | registerType |
      | invalid          | asd         | not          |
      | asd@asd.com      | asd         | not          |
      | invalid12        | valid123    | not          |
      | register@asd.com | 123register | be           |
