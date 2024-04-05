# Feature files should only have one feature. Multiple scenarios are allowed
#
# Feature
#   Scenario
#       Given/When/Then
#
# Feature: What broad feature of your software is being tested (example: Login system should be secure)
# Scenario: A test case generated from the feature (example: Users with an account should only be able to access their account with valid credentials)
# Given: the first step of the test (example: Given the User is on the login page)
# When: a necessary step for completing the Scenario (example: When the user enters their login credentials)
# Then: the expected outcome (example: Then the user should be sent to their home page in the application)
#
# Background: shared Given steps between scenarios
# Scenario Outline: use this when you want to paramaterize your scenario in the feature file
# Examples: the test data you will use in your Scenario Outlines


Feature: English Users of Wikipedia should be able to navigate the site

  Background: English Users should start on the main Wikipedia page
    Given   The User is on the Wikipedia homepage

  Scenario: English Users should be able to navigate to the English homepage
    When    The User clicks the English link
    Then    The User should be redirected to the English homepage

  Scenario Outline: English Users should be able to search for content on the main homepage
    When    The User enters "<Content>" into the search bar
    When    The User clicks the search button
    Then    The User should be redirected to the article page with "<Title>" title
  Examples:
    | Content  | Title             |
    | puppy    | Puppy - Wikipedia |
    | apple    | Apple - Wikipedia |
