Feature: Get All Phone Names

  Scenario: Validate phone names start with a specific prefix
    Given I get all objects
    Then I verify all phone names start with "Apple"
