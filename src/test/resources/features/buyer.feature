# language: en
@buyer @api @post
Feature: Buyer Management via API
  As a QA tester
  I want to create and validate buyers
  So that I can ensure buyer data is correctly processed

  Background:
    Given the Car Marketplace API is available

  @smoke @create
  Scenario: Create a new buyer
    When I create a new buyer
    Then the response status code should be 201
    And I validate buyer schema
    And I store the buyerId
    And the response contains valid buyer information