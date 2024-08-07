Feature: Test The Functionality Of Tests Module
  Scenario: Verify the Search Review Tests functionality
    Given user logged in to the admin portal
    Then search for an existing test by entering patient id or patient name


  Scenario: Verify the Date Range in Review Tests functionality
    Given user logged in to the admin portal
    Then search for an existing test by entering start and end date

  Scenario: Verify the Select Reference Test dropdown functionality
    Given user logged in to the admin portal
    Then search for QC and Resulting

  Scenario: Verify the Applicable Status dropdown functionality
    Given user logged in to the admin portal
    Then search multiple status from applicable status dropdown

  Scenario: Verify the Search for Find Test functionality
    Given user logged in to the admin portal
    Then search for an existing test