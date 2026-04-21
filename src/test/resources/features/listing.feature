# language: en
@listing @api @post
Feature: Car Listing Management via API
  As a QA tester
  I want to create and validate car listings
  So that I can ensure listings are correctly stored in the system

  Background:
    Given the Car Marketplace API is available

  @smoke @create
  Scenario: Create a new car listing
    When I create a new car listing
    Then the response status code should be 201
    And I store the listingId
    And the listing status should be "ACTIVE"