package com.car.api.stepdefinitions;

import com.car.api.builders.*;
import com.car.api.services.BuyerApi;
import com.car.api.services.ListingApi;
import com.car.api.services.TransactionApi;
import com.car.api.utils.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class E2ECarMarketplaceSteps {

    private final TestContext context;

    private final ListingApi listingApi = new ListingApi();
    private final BuyerApi buyerApi = new BuyerApi();
    private final TransactionApi transactionApi = new TransactionApi();

    public E2ECarMarketplaceSteps(TestContext context) {
        this.context = context;
    }

    // =========================
    // FULL FLOW
    // =========================
    @When("I create a full transaction flow")
    public void full_flow() {

        Response listing = listingApi.createNewCarListing(
                ListingBuilder.defaultListing()
        );
        context.setListingId(listing.jsonPath().getString("listingId"));

        Response buyer = buyerApi.createBuyer(
                BuyerBuilder.defaultBuyer()
        );
        context.setBuyerId(buyer.jsonPath().getString("buyerId"));

        Response transaction = transactionApi.createTransaction(
                TransactionBuilder.defaultTransaction(
                        context.getListingId(),
                        context.getBuyerId()
                )
        );

        context.setTransactionId(
                transaction.jsonPath().getString("transactionId")
        );

        context.setResponse(transaction);
    }

    // =========================
    // SUCCESS VALIDATION (NO Thread.sleep)
    // =========================
    @Then("the transaction should be successful")
    public void transaction_success() {

        String transactionId = context.getTransactionId();

        WaitUtils.waitUntilTrue(() -> {

            Response response = transactionApi.getTransactionById(transactionId);

            context.setResponse(response);

            return "COMPLETED".equals(
                    response.jsonPath().getString("status")
            );

        }, 50);

        assertEquals(
                "COMPLETED",
                context.getResponse().jsonPath().getString("status")
        );
    }

    // =========================
    // SCHEMA VALIDATION
    // =========================
    @Then("all schemas should be valid")
    public void validate_all_schemas() {

        SchemaValidator.validate(
                context.getResponse(),
                "transaction-schema"
        );
    }
}