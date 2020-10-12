Feature: Verify user can get weather forecast for any given location
 
  Scenario: I can get a forecast from valid latitude and longitude location
    When I call weather endpoint "https://api.weather.gov/gridpoints/TOP/" with latitude of "32" and longitude of "80"
    Then I should get a status code of "200"
    And I can print out hourly updates
