#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Demo blaze application login scenarios

  Scenario: Valid login
    Given User is on the Login Page
    When User enters valid username and password
    And User clicks on the Login button
    Then User should be redirected to the Home Page
    
#  Scenario Outline: Valid login with multiple users
#   Given User is on the Login Page
#    When User enters username "<username>" and password "<password>"
#    And User clicks on the Login button
#    Then User should be redirected to the Home Page
#
#    Examples:
#      | username   | password  |
#      | admin2301  | admin     |
#      | admin2301  | admin     | 
      
  