Feature: hello service

  Scenario: hello service returns correct person

    When I call the getPerson service
    Then I get the person with name "Aidana" and address "Lyngby"