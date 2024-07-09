Feature: Test the Veterinarian Functionality
  Scenario: Add a Veterinarian
    Given user logged in to the application
    When Add a veterinarian
    Then Added Veterinarian is displayed

    Scenario: Delete the added Veterinarian
      Given user logged in to the application
      When search for added Veterinarian and delete it.
      Then deleted Veterinarian is not displayed