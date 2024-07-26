Feature: Test The Functionality Of Order Test In Home Page
  Scenario: verify create patient on the fly from test ordering while turn on the colony mode
    Given user logged in to the application
    Then create a patient from home page while turn on the colony mode
    Then created patient is displayed on patient page and delete it

  Scenario: verify search for a patient or create patient on the fly from test ordering
    Given user logged in to the application
    Then create a patient from home page
    Then created patient is displayed on patient page and delete it