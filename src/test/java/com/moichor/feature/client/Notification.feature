Feature: Test The Functionality Of Notification
  Scenario: Verify Message sent in Notification
    Given user logged in to the application
    Then select a test and send a message
    Then sent message is displayed on notification page

  Scenario: Verify Message Receive in Admin Notification
    Given user logged in to the admin portal
    Then search for message received from client side
    Then send a message back to the client


  Scenario: Verify Message Received In Client Notification
    Given user logged in to the application
    Then search for a message received from admin side

  Scenario: Verify the search by Patient Name or ID functionality
    Given user logged in to the admin portal
    Then search the existing notification by patient name

  Scenario: Verify Filter by clinic functionality
    Given user logged in to the admin portal
    Then search the existing notification by clinic name