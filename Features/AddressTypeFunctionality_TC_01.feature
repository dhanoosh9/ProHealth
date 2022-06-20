@SmokeTest
Feature: Verifying Address type functionality

  Background: login into the application
    Given Navigate to the prohealth application
    And Enter practice valid username and password and click on login button
    And Select apollo and admin values in dropdown
    Then Click on Login button
    

  Scenario: Verify_view page of domain values
    When Mouse hover on settings option
    And Click on domain values button
    Then Verify address type table and add button is displayed
    And Verify the list of security domain values are displayed by default
    And Click on the list of all security values one by one
  