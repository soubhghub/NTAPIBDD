Feature: Validate ID Not Null

  Scenario: Validate IDs are not null
    Given I get all objects
    Then I verify ID is not null
