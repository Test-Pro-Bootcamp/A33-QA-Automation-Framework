Feature: Verify tests related to Search page

  Background:
    Given I am logged in the Koel
  Scenario: Search to find a song
    When I type a search keyword "dark"
    Then I can find a song

  Scenario: Search to find an artist
    When I type a search keyword "dark"
    Then I can find an artist

  Scenario: Search to find an album
    When I type a search keyword "dark"
    Then I can find an album