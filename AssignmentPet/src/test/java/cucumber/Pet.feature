@tag
Feature: Place an order on JPetStore Website
  I want to use this template for my feature file

  Background: 
    Given I landed on JPetStore Website

  @Regression
  Scenario Outline: Positive test for submitting an order
    Given Login with Username <username> and Password <password>
    And Select a Category <category>
    And Select a Product <product>
    When I add an Item <item> to Cart
    And Checkout and confirm the order
    Then "Thank you, your order has been submitted." message is displayed on ConfirmationPage

    Examples: 
      | username  | password | category | product  | item                  |
      | Niveditha | Daseena  | Fish     | Goldfish | Adult Female Goldfish |
