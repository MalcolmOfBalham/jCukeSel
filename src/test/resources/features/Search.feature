Feature: Search
  Run search functions in various sites

  Scenario: Search google for news
    Given google is opened
    When search for news
    Then news articles are returned

  Scenario: Search Bing for news
    Given Bing is opened
    When search Bing for news
    Then news articles are returned on Bing


