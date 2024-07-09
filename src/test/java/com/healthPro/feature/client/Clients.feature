Feature: Test the client functionality

  Scenario: Add a client
    Given user logged in to the application
    When Add a Client
    Then Added client is displayed


  Scenario: Add a Patient
    Given user logged in to the application
    When Select the added client
    And add a patient
    Then patient is displayed


  Scenario: Delete the added client
    Given user logged in to the application
    When Select the added client
    And delete the selected client
    Then deleted client is not displayed