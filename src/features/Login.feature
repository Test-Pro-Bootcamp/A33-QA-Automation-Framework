Feature: Login feature

  Scenario: Login Success
    Given User opens the browser
    And User is on Login page
    When User enters valid email "demo@class.com"
    And User enters the valid password "te$t$tudent"
    And Clicks submit button
    Then User is logged in
#    (Avatar icon is displayed)