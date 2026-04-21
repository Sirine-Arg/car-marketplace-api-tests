# language: en
@cars @api @get
Feature: Car Listings Management via API
  As a QA tester
  I want to verify car listing endpoints
  So that I can ensure the API returns correct listing data

  Background:
    Given the Car Marketplace API is available

  @smoke @get
  Scenario: Retrieve all car listings
    When I send a GET request to the "GetAllListings" endpoint
    Then the response status code should be 200
    And I validate listing schema
    And the response contains a list of car listings
    And each listing contains vehicle details and price information