Feature: PLaying with dogs
  Scenario: Searching for a random breed
    When searching a random breed
    And a success message comes through


  Scenario Outline: searching for a specific dog
    When searching for a "<dog>"
    And its found
    Examples:
      |dog|
      |bulldog |

  Scenario: Retrieving a list of all sub-breeds
    When retrieving all sub-breeds for bulldogs
    And I get a response
