Feature: As a vehicle owner
         I want to check my vehicle details
         So I know how much it is worth

  Scenario: Search for vehicles in supported files only
    Given a text file which contains some vehicle registration numbers
    When I read the content of the file and do a vehicle search
    Then a free car check result is displayed for the vehicle registration numbers
