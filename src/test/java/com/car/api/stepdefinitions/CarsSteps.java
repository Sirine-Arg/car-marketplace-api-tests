package com.car.api.stepdefinitions;

import com.car.api.builders.SchemaValidator;
import com.car.api.services.ListingApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CarsSteps {




    private final TestContext context;
    private final ListingApi listingApi = new ListingApi();

    public CarsSteps(TestContext context) {
        this.context = context;
    }

    // =========================
    // GET ALL LISTINGS
    // =========================
    @When("I send a GET request to the {string} endpoint")
    public void i_send_a_get_request_to_the_endpoint(String endpoint) {

        Response response = listingApi.getAllListings(endpoint);

        context.setResponse(response);
    }

    // =========================
    // SCHEMA VALIDATION
    // =========================
    @Then("I validate listing schema")
    public void i_validate_listing_schema() {

        SchemaValidator.validate(
                context.getResponse(),
                "listing-schema"
        );
    }

    // =========================
    // VALIDATE LIST EXISTS
    // =========================
    @Then("the response contains a list of car listings")
    public void the_response_contains_a_list_of_car_listings() {

        List<Object> listings =
                context.getResponse().jsonPath().getList("$");

        assertNotNull(listings);
        assertFalse(listings.isEmpty());
    }

    // =========================
    // VALIDATE STRUCTURE
    // =========================
    @Then("each listing contains vehicle details and price information")
    public void each_listing_contains_vehicle_details_and_price_information() {

        List<Object> listings =
                context.getResponse().jsonPath().getList("$");

        // Check first item (enough for structure validation)
        assertNotNull(listings);

        String vehicleVin =
                context.getResponse().jsonPath().getString("[0].vehicle.vin");

        String priceCurrency =
                context.getResponse().jsonPath().getString("[0].price.currency");

        assertNotNull(vehicleVin);
        assertNotNull(priceCurrency);
    }
}
