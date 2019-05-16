Feature: Top Navigation Elements
  As a User i want to have a Top Navigation that will contain:
  Before Login: RecipeBook, Login, Register
  After Login: RecipeBook, Recipes, Shopping List, Logout,
                Manage (Save Data, Fetch Data, Settings)

  Background:
    Given user have a valid account
    And user navigate to application url

    Scenario: Verify elements Before Login
      Then user verify all elements from TopNavigation before login
      And user go to Login Page
      And user perform login
      Then user verify all elements from TopNavigation after login
      And user Log Out
      Then delete account
