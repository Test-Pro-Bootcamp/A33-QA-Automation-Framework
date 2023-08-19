Feature: Verify the login feature is working as expected
  Scenario: Login success
    #@Before
    Given I open Login Page
    When I enter email "vera1077@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
    #@After