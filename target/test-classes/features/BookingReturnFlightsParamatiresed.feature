Feature: Search for flights from Emirates

  @emirates2
  Scenario Outline: Search return flights
    Given User should choose first "<city1>"
    And User should choose second "<city2>"
    And User should choose flights "<first date>"
    And User should choose return date "<return date>"
    And User should choose "<number>" of Adult passenger
    And User should choose "<number>" of child passengers
    And User should choose "<number>" of baby passengers
    And User Should choose "<class>" of flight
    When User should click on search button
    Then User should see available flights for correct dates
    Examples:
      | city1    | city2     | first date | return date | number | number | number | class           |
      | Dubai    | İstanbul  | 1          | 5           | 1      | 0      | 0      | Economy Class   |
      | New York | Akra      | 3          | 7           | 3      | 1      | 1      | Premium Economy |
      | Kahire   | Barselona | 15         | 21          | 1      | 1      | 1      | First Class     |

