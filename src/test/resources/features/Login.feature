Feature : Verify the login feature is working as expected

  Scenario:  Login Success
    Given I open Login Page
    When I enter email "test@test.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
