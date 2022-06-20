@SmokeTest
Feature: Verifying users functionality

  Background: login into the application
    Given Navigate to the prohealth application
    And Enter practice valid username and password and click on login button
    And Select apollo and admin values in dropdown
    Then Click on Login button

  Scenario: Verify_view page of users functionality
    When Mouse hover on settings
    And Click on users button
    Then Verify the column names of users view page
    And Verify the add button is displayed
