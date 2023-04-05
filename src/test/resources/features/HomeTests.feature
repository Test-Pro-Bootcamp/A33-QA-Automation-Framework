Feature: Tests mainly related to Home page

  Scenario: Play Song
    Given I open Login Page
    When I enter email "test@test.com"
    And I enter password "te$t$tudent"
    And I submit
    And I choose the song
    And I play the song
    Then The song play

   Scenario: Pause Song
     Given I open Login Page
     When I enter email "test@test.com"
     And I enter password "te$t$tudent"
     And I submit
     And I choose the song
     And I play the song
     And I stop the song
     Then The song stops