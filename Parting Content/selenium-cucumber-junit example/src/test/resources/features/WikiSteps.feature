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