  Feature: LoginPage
  Scenario: Sccessful login with valid credentials
    Given User launche chrome Browser
    When User opens URL as "https://admin-demo.nopcommerce.com/"
    And User entre Email as "admin@yourstore.com" and Password as "admin"
    And Click login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
#    Then page Title should be "Your stor.Login"
    Then close browser

    Scenario Outline: data drive
      Given User launche chrome Browser
      When User opens URL as "https://admin-demo.nopcommerce.com/"
      And User entre Email as "<email>" and Password as "<password>"
      And Click login
      Then Page Title should be "Dashboard / nopCommerce administration"
      When User click on Log out link
#    Then page Title should be "Your stor.Login"
      Then close browser
      Examples:
        | email |password |
      |admin@yourstore.com| admin |
      |admin@yourstore.com| admin123|
      |admin123@yourstore.com|admin |
      |admin123@yourstore.com|admin123|








