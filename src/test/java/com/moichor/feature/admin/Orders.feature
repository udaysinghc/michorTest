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