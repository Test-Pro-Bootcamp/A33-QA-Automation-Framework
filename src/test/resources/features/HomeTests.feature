Feature: Tests mainly related to Home page

  Background:
    Given I am logged in the Koel

  Scenario: Play Song
    And I click AllSongs page
    And I choose the song
    And I play the song
    Then The song play

   Scenario: Pause Song
     And I click AllSongs page
     And I choose the song
     And I play the song
     And I stop the song
     Then The song stops