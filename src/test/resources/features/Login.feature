Feature: Verify the login feature is working as expected

  Scenario: Login Success
    Given I open Login Page
    When I  enter email "krista_ua86@gmail.com"
    And I enter password "te$t$tudent"
    And I click submit
    Then I'm logged in

