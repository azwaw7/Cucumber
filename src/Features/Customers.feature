Feature: Custumers
  Background: Below are the common steps for each scenario
    Given User launche chrome Browser
    When User opens URL as "https://admin-demo.nopcommerce.com/"
    And User entre Email as "admin@yourstore.com" and Password as "admin"
    And Click login
    Then User can view Dashbord

  Scenario: Add a new customer
    When User click on customer Menu
    And click on customer Menu item
    And click on add new button
    Then User can view Add new customer page
    When User entre customer info
    And click on save
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
    Scenario: Search Customer By EMailID
      When User click on customer Menu
      And click on customer Menu item
      And Enter customer Email
      When Click on searche button
      Then User should found Email in the Searche table
      And close browser
      Scenario: Search customer by firstname and lastname;
        When User click on customer Menu
        And click on customer Menu item
        Then Entre Customer Firstname
        And entre Customer LastName
        When Click on searche button
        Then User should found Name in the Search tabel
        And close browser




