Feature: Test The Functionality Of References
  Scenario: Verify the Add Bin, Search for Added Bin, Edit the Bin, Delete The Bin functionalities
    Given user logged in to the admin portal
    Then add a bin
    Then search for an added bin
    Then edit the added bin
    Then delete the bin

  Scenario: Verify the Add Issue, Search for Added Issue, Edit the Issue, Delete the Issue functionalities
    Given user logged in to the admin portal
    Then add a issue and search for added issue
    Then edit the issue and delete the issue


  Scenario: Verify the Add Variable, Search for Added Variable, Edit the Variable, Delete the Variable functionalities
    Given user logged in to the admin portal
    Then add a variable and search for added variable
    Then edit the variable and delete the variable


  Scenario: Verify the Add Value, Search for Added Value, Edit the Value, Delete the value functionalities
    Given user logged in to the admin portal
    Then add a value
    And search for added value
    Then edit the added value
    And delete the added value
    Then search the value by breed name

  Scenario: Verify the Add Species , Search For Added Species, Edit The Species, Delete The Species functionalities
    Given user logged in to the admin portal
    Then add a new species from admin portal
    And search for added species
    Then edit the species
    And delete the species

  Scenario: Verify the Add Question functionality, Search The Added Question, Edit The Question, Delete The Added Question
    Given user logged in to the admin portal
    Then add a question
    And search for added question
    Then edit the question
    And delete the question

   Scenario: verify The Add Test Functionality, Search The Added Test, Edit The Added Test
     Given user logged in to the admin portal
     Then add a test from test module
     And search for the added test
     Then edit the added test

   Scenario: Verify The Add Test Group, Search The Added Test Group, Sorting filter, Edit The Test Group, Delete The Test Group Functionalities
     Given user logged in to the admin portal
     Then add a test group
     And search for added test group
     Then edit the test group
     And delete the test group
     Then check the test group sorting filter functionality

   Scenario: Verify The Add Item, Search The Added Test Group, Edit The Added Item, Delete The Added Item, Sorting Filter Functionalities
     Given user logged in to the admin portal
     Then add a item
     And search the added item
     Then edit the item
     And delete the added item
     Then check the item sorting filter functionality

    Scenario: Verify The Add Bundle, Search For Added Bundle, Edit The Bundle, Delete The Added Bundle, Sorting Filter Functionalities
      Given user logged in to the admin portal
      Then add a bundle
      And search for added bundle
      Then edit the added bundle
      And delete the added bundle
      Then check the bundle sorting filter functionality

    Scenario: Verify The Add Volume Tier, Search For Added Volume Tier, Edit The Volume Tier, Delete The Volume Tier
      Given user logged in to the admin portal
      Then add a volume tier
      And search the added volume tier
      Then edit the added volume tier
      Then delete the added volume tier

    Scenario: Verify The Add Clinical Template, Search For Added Clinical Template, Edit The Clinical Template, Delete The Clinical Template
      Given user logged in to the admin portal
      Then add a clinical template
      And search the added clinical template
      Then edit the clinical template
      Then delete the clinical template

    Scenario: Verify The Add Conditions, Search Conditions, Edit Conditions, Delete Conditions Functionalities
      Given user logged in to the admin portal
      Then add a conditions
      And search for added conditions
      Then edit the conditions
      Then delete the conditions
      Then check the conditions sorting functionality

    Scenario: Verify The Add Task, Search Task, Edit Task, Delete Task Functionalities
      Given user logged in to the admin portal
      Then add a task
      And search the task
      Then edit the task
      Then delete the task

