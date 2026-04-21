package com.car.api.stepdefinitions;

import com.car.api.builders.ListingBuilder;
import com.car.api.services.ListingApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListingSteps {

    private final TestContext context;
    private final ListingApi listingApi = new ListingApi();

    public ListingSteps(TestContext context) {
        this.context = context;
    }

    // =========================
    // CREATE LISTING
    // =========================
    @When("I create a new car listing")
    public void create_a_new_car_listing() {

        Response response = listingApi.createNewCarListing(
                ListingBuilder.defaultListing()
        );

        context.setResponse(response);

        String listingId = response.jsonPath().getString("listingId");
        context.setListingId(listingId);
    }

    // =========================
    // STORE ID (optional but safe)
    // =========================
    @Then("I store the listingId")
    public void i_store_the_listing_id() {

        String listingId =
                context.getResponse().jsonPath().getString("listingId");

        context.setListingId(listingId);

        assertNotNull("listingId should not be null", listingId);
    }

    // =========================
    // LISTING STATUS VALIDATION
    // =========================
    @Then("the listing status should be {string}")
    public void the_listing_status_should_be(String expectedStatus) {

        String actualStatus =
                context.getResponse().jsonPath().getString("status");

        assertEquals(expectedStatus, actualStatus);
    }
}