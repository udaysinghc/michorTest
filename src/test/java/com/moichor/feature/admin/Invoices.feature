Feature: Test The Functionality Of Invoices
  Scenario: Verify the Generate Invoice functionality
    Given user logged in to the application
    Then add a test
    Then user logged in to the admin portal
    Then generate the invoices
    Then issue the invoice for created payment status
    Then cancel some order

  Scenario: Verify the Search Invoice functionality
    Given user logged in to the admin portal
    Then search for an existing invoice

  Scenario: Verify the Date Range functionality
    Given user logged in to the admin portal
    Then search for an existing invoice between dates

  Scenario: Verify the Clinic Dropdown functionality
    Given user logged in to the admin portal
    Then search for the particular invoice

  Scenario: Verify the Payment and Issue Status functionality
    Given user logged in to the admin portal
    Then check for each payment status


  Scenario: Verify the Download Invoice functionality
    Given user logged in to the admin portal
    Then download the invoice from an existing invoice

  Scenario: Verify the Edit Invoice functionality
    Given user logged in to the admin portal
    Then edit the price of any issued invoice
    Then mark the invoice as paid


  Scenario: Verify the Email Invoice functionality
    Given user logged in to the admin portal
    Then send the invoice email
