Feature: Test The Functionality Of Clinics Module
  Scenario: Verify the Add Clinic functionality
    Given user logged in to the admin portal
    Then Add A Clinic From the Clinics Module
    Then Added Clinic Is Displayed On Clinics Page


  Scenario: Verify the edit clinic functionality
    Given user logged in to the admin portal
    Then search for existing clinic
    And edit the clinic details