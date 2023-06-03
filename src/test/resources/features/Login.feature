Feature: Verify the Login feature is working as expected

  Scenario Outline: Login Success
    Given I open Login Page
    When I enter email "Guadalupe.medina@testpro.io"
    And I enter password "DoingitBig23!"
    And I submit
    Then I am logged in
    Examples:
