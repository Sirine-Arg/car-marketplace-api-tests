package com.car.api.stepdefinitions;

import com.car.api.services.LoginApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginSteps {

    private final LoginApi loginApi;
    private final TestContext context;

    private Map<String, Object> loginPayload;

    public LoginSteps(TestContext context) {
        this.context = context;
        this.loginApi = new LoginApi();
    }

    @Given("I have valid seller credentials username {string} and password {string}")
    public void valid_credentials(String username, String password) {

        loginPayload = new HashMap<>();

        loginPayload.put("username", username);
        loginPayload.put("password", password);
    }

    @Given("I have invalid credentials username {string}")
    public void invalid_credentials(String username) {

        loginPayload = new HashMap<>();
        loginPayload.put("username", username);
        // password intentionally missing
    }

    @When("I send a POST request to the login endpoint")
    public void send_login_request() {

        Response response = loginApi.login(loginPayload);
        context.setResponse(response);
    }

    @When("I send a POST request to the login endpoint without password")
    public void send_login_without_password() {

        Response response = loginApi.login(loginPayload);
        context.setResponse(response);
    }

    @When("I send a POST request to the login endpoint with username {string} and password {string}")
    public void send_login_dynamic(String username, String password) {

        loginPayload = loginApi.buildLoginPayload(username, password);

        Response response = loginApi.login(loginPayload);
        context.setResponse(response);
    }

    @Then("the response should contain an authentication token")
    public void assert_token_exists() {

        String token = context.getResponse().jsonPath().getString("token");

        assertNotNull("Token is null", token);
    }

    @Then("the token should not be empty")
    public void assert_token_not_empty() {

        String token = context.getResponse().jsonPath().getString("token");

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Then("the response should contain an error message {string}")
    public void assert_error_message(String expected) {

        String actual = context.getResponse().jsonPath().getString("error");

        assertEquals(expected, actual);
    }

    @Then("the response should not contain a token")
    public void assert_no_token() {

        assertNull(context.getResponse().jsonPath().getString("token"));
    }
}