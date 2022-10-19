@GoogleBooks
Feature: Validate values from Google Books Website
  I want to use this template for my feature file

  @Book
  Scenario Outline: Validate selflink from Google Books Website
    Given Request to Google Books Api
    When Extract selflink from the Response
    Then verify <selflinkvalue> is same as extracted selflink

    Examples: 
      | selflinkvalue                                                 |
      | https://www.googleapis.com/books/v1/volumes/nKdJDwAAQBAJ      |
