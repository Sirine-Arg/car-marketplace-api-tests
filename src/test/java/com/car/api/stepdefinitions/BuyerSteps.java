package com.car.api.stepdefinitions;

import com.car.api.builders.BuyerBuilder;
import com.car.api.builders.SchemaValidator;
import com.car.api.services.BuyerApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class BuyerSteps {

    private final TestContext context;
    private final BuyerApi buyerApi = new BuyerApi();

    public BuyerSteps(TestContext context) {
        this.context = context;
    }

    // =========================
    // GIVEN
    // =========================
//    @Given("the Car Marketplace API is available")
//    public void the_car_marketplace_api_is_available() {
//        // Usually nothing to do (base URI is set in Hooks)
//        assertNotNull("API base URI is not set", context);
//    }

    // =========================
    // CREATE BUYER
    // =========================
    @When("I create a new buyer")
    public void i_create_a_new_buyer() {

        Response response = buyerApi.createBuyer(
                BuyerBuilder.defaultBuyer()
        );

        context.setResponse(response);
        context.setBuyerId(
                response.jsonPath().getString("buyerId")
        );
    }

    // =========================
    // STATUS CODE
    // =========================
//    @Then("the response status code should be {int}")
//    public void the_response_status_code_should_be(Integer expectedStatus) {
//
//        int actualStatus = context.getResponse().getStatusCode();
//
//        assertEquals(expectedStatus.intValue(), actualStatus);
//    }

    // =========================
    // SCHEMA VALIDATION
    // =========================
    @Then("I validate buyer schema")
    public void i_validate_buyer_schema() {

        SchemaValidator.validate(
                context.getResponse(),
                "buyer-schema"
        );
    }

    // =========================
    // STORE BUYER ID
    // =========================
    @Then("I store the buyerId")
    public void i_store_the_buyer_id() {

        context.setBuyerId(
                context.getResponse()
                        .jsonPath()
                        .getString("buyerId")
        );
    }

    // =========================
    // BUSINESS VALIDATION
    // =========================
    @Then("the response contains valid buyer information")
    public void the_response_contains_valid_buyer_information() {

        String email = context.getResponse().jsonPath().getString("email");
        String firstName = context.getResponse().jsonPath().getString("firstName");
        String phone = context.getResponse().jsonPath().getString("phone");

        assertNotNull(email);
        assertTrue(email.contains("@"));

        assertNotNull(firstName);
        assertFalse(firstName.isEmpty());

        assertNotNull(phone);
        assertTrue(phone.startsWith("+"));
    }
}