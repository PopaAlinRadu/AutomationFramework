Feature: Delete Account Functionality
  As a User i want to be able to delete my account
  After Delete Account I want to be redirected to Home Page

  Background:
    Given user have a valid account
    And user navigate to application url
    And user go to Login Page
    Then user perform login

  Scenario: Verify Delete Account functionality
    When User go to Settings
    And User validate Settings Page
    Then User Delete Account
    Then user validates the homepage page
    And user go to Login Page
    And user perform login
    Then user should "not" successfully logged in
