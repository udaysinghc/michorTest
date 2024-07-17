Feature: Test the Functionality of LabTestDirectory
  Scenario: Verify View Lab Test Directory
    Given user logged in to the application
    Then check the Lab Test Directory page
    Then check for each element in test bundles

  Scenario: Verify Search Lab Test Directory
    Given user logged in to the application
    Then search the relevant test from search lab test directory
