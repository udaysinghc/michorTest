Feature: Test The Functionality Of Logistics Module
  Scenario: Verify the Search Test by tracking number functionality
    Given user logged in to the admin portal
    Then search the sample request by tracking number

  Scenario: Verify the Date Range functionality
    Given user logged in to the admin portal
    Then search the sample request between the dates

  Scenario: Verify the filter by clinic dropdown functionality
    Given user logged in to the admin portal
    Then search the sample request by selecting clinic

  Scenario: Verify the Shipment Status functionality
    Given user logged in to the admin portal
    Then check the shipment status

  Scenario: Verify the search by Tracking Number functionality
    Given user logged in to the admin portal
    Then search the supplies requests by tracking number

  Scenario: Verify the Date Range filter functionality
    Given user logged in to the admin portal
    Then search the supplies between dates

  Scenario: Verify the Filter by Clinic dropdown functionality
    Given user logged in to the admin portal
    Then search the supplies by selecting clinic

  Scenario: Verify the Request Supplies CTA functionality
    Given user logged in to the admin portal
    Then add supplies request

  Scenario: Verify the New Label functionality
    Given user logged in to the admin portal
    Then check new label button functionality

  Scenario: Verify the search by Test ID functionality
    Given user logged in to the application
    Then fetch the test id from created test
    And user logged in to the admin portal
    Then search sample receiving by created test id