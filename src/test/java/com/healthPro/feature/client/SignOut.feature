Feature: Test the functionality of sign out
  Scenario: Verify the Sign Out functionality
    Given user logged in to the application
    Then sign out from the application
    Then login page is displayed