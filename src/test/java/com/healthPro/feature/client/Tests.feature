Feature: Test the Functionality of Tests Page
  Scenario: Add a test from test page
    Given user logged in to the application
    Then add a test


  Scenario: Edit a test from test page
    Given user logged in to the application
    Then edit the test

   Scenario: Delete a test from test page
     Given user logged in to the application
     Then delete the test


  Scenario: Verify View Filter tests by statuses
    Given user logged in to the application
    Then check all test status


  Scenario: Verify Sample info sheet from Info Sheet button from test page
    Given user logged in to the application
    Then check for info sheet


  Scenario: Verify Test Archiving
    Given user logged in to the application
    Then archive the test
    Then archive test is displayed on archive page

  Scenario:  Verify Filter test by Ordering Veterinarians
    Given user logged in to the application
    Then select the veterinarian from test module

  Scenario: Verify Search Test by patient name
    Given user logged in to the application
    Then search for existing patient from test module



