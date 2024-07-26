Feature: Test The Functionality Of Users Module
  Scenario: Verify the Add User functionality, Search User functionality, Edit User functionality, Deactivate User functionality, Restore User functionality, Reset Password functionality
    Given user logged in to the admin portal
    Then Add a user and search for added user
    Then Edit the user
    Then Deactivate the user and restore the deactivated user
    Then Reset the password of existing user
    Then Home page is displayed