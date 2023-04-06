Feature: Tests mainly related to Home page

  Scenario: Play Song
    Given I am logged in the Koel
    And I choose the song
    And I play the song
    Then The song play

   Scenario: Pause Song
     Given I am logged in the Koel
     And I choose the song
     And I play the song
     And I stop the song
     Then The song stops