@GoogleBooks
Feature: Validate values from Google Books Website
  I want to use this template for my feature file

  @Book
  Scenario Outline: Validate ID from Google Books Website
    Given Request to Google Books Api
    When Extract id from the Response
    Then verify <idvalue> is same as extracted id

    Examples: 
      | idvalue           |
      | nKdJDwAAQBAJ      |
