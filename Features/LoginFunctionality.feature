Feature: Login functionality

  @LoginTest
  Scenario Outline: Login functionality with valid credentials
    Given Navigate to the Prohealth application
    When Enter practice <Practice> valid username <Username> and password <Password> and click on login button
    And Select facility <Facility> and roles <Roles> values in dropdowns
    Then Click on the Login button

    Examples: 
      | Practice | Username | Password | Facility | Roles |
      | user     | admin    | 123qwe   |        1 |     1 |
      | test     | admin    | 123qwe   |        2 |     1 |
      | user     | admin    | 123qwe   |        3 |     1 |
      | test     | admin    | 123qwe   |        4 |     1 |
