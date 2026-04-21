# language: en
@transaction @api @e2e
Feature: Transaction Management via API
  As a QA tester
  I want to create and validate transactions
  So that I can ensure payments and purchases work correctly

  Background:
    Given the Car Marketplace API is available

  @smoke @e2e
  Scenario: Create a transaction from listing and buyer
    Given a listing is created
    And a buyer is created
    When I create a transaction using the listing and buyer
    Then the response status code should be 201
    And I validate transaction schema
    And the transaction status should be "COMPLETED"
    And the transaction contains correct amount and currency