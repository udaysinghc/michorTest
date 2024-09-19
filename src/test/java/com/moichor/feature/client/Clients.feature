Feature: Test the client functionality
  Scenario: Verify the create "Clients" functionality
    Given user logged in to the application
    Then Add a Client
    Then Added client is displayed

  Scenario: Verify the edit "Client" functionality
    Given user logged in to the application
    Then edit the client


  Scenario: Verify the "Patient" functionality from Clients.
    Given user logged in to the application
    Then add a patient

  Scenario: Verify the delete "Client" functionality.
    Given user logged in to the application
    Then delete the selected client