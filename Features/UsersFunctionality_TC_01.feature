@SmokeTest
Feature: Verifying users functionality

  Scenario: Verify_view page of users functionality
    Given Navigate to prohealth application
    And Enter practice, valid username and password and click on login button
    And select apollo and admin values in dropdown
    Then Click on login button
    When Mouse hover on settings
    And Click on users button
    Then Verify the column names of users view page
    And Verify the add button is displayed
