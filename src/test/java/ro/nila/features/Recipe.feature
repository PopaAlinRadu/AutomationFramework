Feature: Recipe page functionality
  As a User
  I want to be able to add recipe/recipes and store it to the DB,
  I want to be able to retrieve the recipe/recipes that are stored in DB
  I want to be able to delete a specific recipe from DB

  Background:
    Given user have a valid account
    And user navigate to application url
    And user go to Login Page
    When user perform login

  Scenario: Verify elements from Recipe Page
    When user validate the Recipe Page
    Then user verify all elements from Recipe Page
    And user Log Out
    Then delete account

#  Scenario: Verify that User can Add and Save a Recipe



