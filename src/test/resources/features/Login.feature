Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "Test321@gmail.com"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am logged in