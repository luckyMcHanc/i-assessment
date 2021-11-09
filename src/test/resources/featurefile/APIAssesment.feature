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



#Feature:
#  Scenario Outline:
#    When you retrieve the list of pets
#    And Confirm if "<pet>" with "<id>" exist
#    Examples:
#    |pet    |id |
#    |doggie |12 |
#
#
#   Scenario:
#     When you add a new pet
#     And Confirm the new pet is added

