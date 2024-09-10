Feature: Test the Functionality of Logistics module
  Scenario: Verify Get sample shipping label
    Given user logged in to the application
    Then select the sample to include in shipping

  Scenario: Verify Request Supplies
    Given user logged in to the application
    Then Select items for supplies

  Scenario: Verify the date range
    Given user logged in to the application
    Then search the sample shipment between dates
