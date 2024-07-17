Feature: Test the functionality of billing module
  Scenario: Verify View Invoice in Billing
    Given user logged in to the application
    Then check for an existing invoice

  Scenario: Verify Download Invoice PDF in Billing
    Given user logged in to the application
    Then check for download invoice pdf