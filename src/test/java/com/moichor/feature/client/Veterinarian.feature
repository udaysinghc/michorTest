
Feature: Test the Veterinarian Functionality
  @veterinarian
  Scenario: Add a Veterinarian
    Given user logged in to the application
    When Add a veterinarian
    Then Added Veterinarian is displayed


  Scenario: Edit a Veterinarian
    Given user logged in to the application
    When Edit a Veterinarian

  Scenario: verify sms notification toggle button
    Given user logged in to the application
    When click on toggle button and verify the message

  Scenario: Delete the added Veterinarian
    Given user logged in to the application
    When search for added Veterinarian and delete it.
    Then deleted Veterinarian is not displayed

