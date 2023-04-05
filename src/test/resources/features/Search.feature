Feature: Verify tests related to Search page

  Scenario: Search to find a song
    Given I am logged in the Koel
    When I type a search keyword "dark"
    Then I can find a song

  Scenario: Search to find an artist
    Given I am logged in the Koel
    When I type a search keyword "dark"
    Then I can find an artist

  Scenario: Search to find an album
    Given I am logged in the Koel
    When I type a search keyword "dark"
    Then I can find an album