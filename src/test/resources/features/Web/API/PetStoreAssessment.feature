
Feature: Playing with Pets
  Scenario Outline: Getting a list of pets
    When you retrieve the list of pets
    And Confirm if "<pet>" with "<id>" exist
    Examples:
    |pet    |id |
    |doggie |12 |


   Scenario:
     When you add a new pet
     And Confirm the new pet is added

