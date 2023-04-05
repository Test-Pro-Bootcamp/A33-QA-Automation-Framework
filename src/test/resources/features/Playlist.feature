Feature: Verify tests related to playlist

  Scenario: Create a playlist
    Given I am logged in the Koel
    When I create a playlist
    Then New playlist name is on the left menu

  Scenario: Delete a playlist
    Given I am logged in the Koel
    When I create a playlist
    And I delete the playlist
    Then The playlist is deleted from the left menu

  Scenario: Rename a playlist
    Given I am logged in the Koel
    When I create a playlist
    And I rename the playlist
    Then The playlist name is changed

  Scenario: Add song to a playlist
    Given I am logged in the Koel
    When I create a playlist
    And I open the AllSongs page
    And I add a song to the playlist
    Then The song is on the playlist

  Scenario: Add song to a playlist by drag and drop
    Given I am logged in the Koel
    When I create a playlist
    And I open the AllSongs page
    And I add a song to the playlist by using drag and drop
    Then The song is on the playlist