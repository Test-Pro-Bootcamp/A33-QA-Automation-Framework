Feature: Verify tests related to AllSongs page

  Scenario: Verify a option to sort songs
    Given I am logged in the Koel
    When I open the AllSongs page
    And I click the song title column
    Then Songs are sorted correctly