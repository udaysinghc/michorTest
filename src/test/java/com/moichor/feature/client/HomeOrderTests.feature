Feature: Test The Functionality Of Order Test In Home Page
  Scenario: Verify Search for Client or Create Client on the fly from Test Ordering
    Given user logged in to the application
    Then add a client from home page
    Then added client is displayed on client page and delete it

  Scenario: Verify Search for Patient or Create Patient on the fly from Test Ordering
    Given user logged in to the application
    Then search for a patient and update a patient

  Scenario: Verify Patient on Colony Mode
    Given user logged in to the application
    Then search for a patient and turn on the colony mode and update the patient


  Scenario: verify the shipping label functionality
    Given user logged in to the application
    Then click on create shipping label element


  Scenario: Verify Search for Test Bundle from Test Ordering
    Given user logged in to the application
    Then add a test from select test menu

  Scenario: verify create patient on the fly from test ordering while turn on the colony mode
    Given user logged in to the application
    Then create a patient from home page while turn on the colony mode
    Then created patient is displayed on patient page and delete it

  Scenario: verify search for a patient or create patient on the fly from test ordering
    Given user logged in to the application
    Then create a patient from home page
    Then created patient is displayed on patient page and delete it