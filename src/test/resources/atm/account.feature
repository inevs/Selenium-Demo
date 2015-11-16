Feature: Cash Withdrawal

  Scenario: Withdraw from Account
    Given I have deposited 100$ in my account
    When I withdraw 25$
    Then I should have 75$ left in my account
    And be given 25$
