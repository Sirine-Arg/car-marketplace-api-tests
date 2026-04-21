# language: en
@e2e #@api @fullflow
Feature: End-to-End Car Marketplace Flow

  Background:
    Given the Car Marketplace API is available

  Scenario: Complete car purchase flow
    When I create a full transaction flow
    Then the transaction should be successful
    And all schemas should be valid
    And the transaction status should be "COMPLETED"