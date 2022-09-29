  Feature: Orange HRM login
  Scenario: Logo presence on OrangeHRM home page
    Given I launche chrome Browser
    When I open orange hrm url
    When I verify that logo present on page
    Then close browser


