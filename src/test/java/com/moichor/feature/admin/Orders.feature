Feature: Test The Functionality Of Orders Module
  Scenario: Verify the Search Order functionality
    Given user logged in to the admin portal
    Then  search for an existing order


  Scenario: Verify the Download Statistic functionality
    Given user logged in to the admin portal
    Then download the statistic functionality


  Scenario: Verify the Date filter functionality
    Given user logged in to the admin portal
    Then search the order while entering date


  Scenario: Verify the Clinic and Species dropdown functionality
    Given user logged in to the admin portal
    Then select the clinic and species from dropdown


  Scenario: Verify the Test and Order Status functionality
    Given user logged in to the admin portal
    Then check all test status in admin portal

  Scenario: Verify the Edit patient from Order page functionality
    Given user logged in to the admin portal
    Then Edit the patient from order page


  Scenario: Verify the View Result functionality from Order page functionality
    Given user logged in to the admin portal
    Then upload the image and send a message with image
    Then reply to that message
    Then turn on historical toggle button

  Scenario: Verify the test validation functionality of view result
    Given user logged in to the admin portal
    Then check for validation test status