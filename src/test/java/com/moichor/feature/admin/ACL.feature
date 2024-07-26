Feature: Test The Functionality OF ACL Module
  Scenario: Verify the Search role functionality under ACL Module
    Given user logged in to the admin portal
    Then Add a role
    Then Added role is displayed on roles page


  Scenario: Verify the edit role functionality under ACL Module
    Given user logged in to the admin portal
    Then Search for an existing role
    Then edit the role

  Scenario: Verify the Add Permission functionality under ACL Module
    Given user logged in to the admin portal
    Then Add a permission
    Then Added permission is displayed on permission page


  Scenario: Verify the Edit Permission functionality under ACL Module
    Given user logged in to the admin portal
    Then Search for an existing permission
    Then edit the permission