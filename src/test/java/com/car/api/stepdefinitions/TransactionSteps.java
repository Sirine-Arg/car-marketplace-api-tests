package com.car.api.stepdefinitions;

import com.car.api.builders.SchemaValidator;
import com.car.api.builders.TransactionBuilder;
import com.car.api.services.TransactionApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.*;


public class TransactionSteps {


    private final TestContext context;
    private final TransactionApi transactionApi = new TransactionApi();

    public TransactionSteps(TestContext context) {
        this.context = context;
    }

    // =========================
    // GIVEN
    // =========================

    @Given("a listing is created")
    public void listing_is_created() {
        assertNotNull(context);
    }

    @Given("a buyer is created")
    public void buyer_is_created() {
        assertNotNull(context);
    }

    // =========================
    // TRANSACTION CREATION
    // =========================
    @When("I create a transaction using the listing and buyer")
    public void create_transaction() {

        Response response = transactionApi.createTransaction(
                TransactionBuilder.defaultTransaction(
                        context.getListingId(),
                        context.getBuyerId()
                )
        );

        context.setResponse(response);
        context.setTransactionId(
                response.jsonPath().getString("transactionId")
        );
    }


    // =========================
    // SCHEMA VALIDATION
    // =========================
    @Then("I validate transaction schema")
    public void validate_schema() {

        SchemaValidator.validate(
                context.getResponse(),
                "transaction-schema"
        );
    }


    // =========================
    // BUSINESS VALIDATION - AMOUNT + CURRENCY
    // =========================
    @Then("the transaction contains correct amount and currency")
    public void validate_amount_and_currency() {

        Double amount = context.getResponse()
                .jsonPath()
                .getDouble("amount");

        String currency = context.getResponse()
                .jsonPath()
                .getString("currency");

        assertNotNull(amount);
        assertTrue(amount > 0);

        assertEquals("EUR", currency);
    }
}