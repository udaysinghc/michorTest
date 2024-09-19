Feature: Test The Functionality OF Alerts Module
  Scenario: Verify Add Alerts, Search For The Alerts, Edit The Alerts, Delete The Alerts Functionalities
    Given user logged in to the admin portal
    Then add a alerts
    And search for added alerts
    Then edit the alerts
    Then delete the alerts

  Scenario: Verify the "All, Critical, Message" Buttons functionality
    Given user logged in to the admin portal
    Then check the functionality of all button