# language: en

@authentication @api @seller
Feature: Seller authentication and listing management via Car Marketplace API
  As a seller of the platform
  I want to authenticate and manage my car listings
  So that I can sell my vehicles

  Background:
    Given the Car Marketplace API is available

  @smoke @login @success
  Scenario: Successful login with valid seller credentials
    Given I have valid seller credentials username "Car-Seller" and password "Cars123!"
    When I send a POST request to the login endpoint
    Then the response status code should be 201
    And the response should contain an authentication token
    And the token should not be empty

  @login @error
  Scenario: Failed login - username without password
    Given I have invalid credentials username "seller1"
    When I send a POST request to the login endpoint without password
    Then the response status code should be 400
    And the response should contain an error message "Invalid credentials"
    And the response should not contain a token

  @login @error @validation
  Scenario Outline: Login attempts with different invalid cases
    When I send a POST request to the login endpoint with username "<username>" and password "<password>"
    Then the response status code should be <status_code>


    Examples:
      | username   | password      | status_code |
      | seller1    | password123   | 400         |
      | seller1    |               | 400         |
      | wrongUser  | wrongPass     | 400         |


