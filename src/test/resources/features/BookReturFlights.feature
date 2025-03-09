
Feature: Search for flights from Emirates
  @emirates
  Scenario: Search return flights
  Given User should choose first city
  And User should choose second city
  And User should choose flights dates
  And Uer should choose number of passengers
  And User Should choose class of flight
  When User should click on search button
  Then User should see available flights for correct dates




