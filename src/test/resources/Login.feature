Feature: Verify the login feature is working as expected

  Scenario: Login Success
    Given I open Login Page
    When I enter email "janezelenova@gmail.com"
    And I enter password "Floridaliving2023$"
    And I submit
    Then I am logged in