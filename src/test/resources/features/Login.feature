Feature: Login feature
  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "taqimed99@gmail.com"
    And I enter password "Med-20115-010499@"
    And I submit
    Then I am logged in