Feature: Search on Google

  Scenario: Search for cucumber
    Given I am at the google homepage
    When search for cucumber
    Then I shoud see several results
