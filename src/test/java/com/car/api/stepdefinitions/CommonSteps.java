package com.car.api.stepdefinitions;

import com.car.api.services.ApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommonSteps {

    private final TestContext context;
    private final ApiClient apiClient;

    // ✅ SINGLE constructor ONLY (required by Cucumber + PicoContainer)
    public CommonSteps(TestContext context, ApiClient apiClient) {
        this.context = context;
        this.apiClient = apiClient;
    }

    @Given("the Car Marketplace API is available")
    public void the_car_marketplace_api_is_available() {
        // API readiness check (optional lightweight validation)
        assertNotNull("TestContext is not initialized", context);
        assertNotNull("ApiClient is not initialized", apiClient);
    }

    @Then("the response status code should be {int}")
    public void verify_status_code(Integer statusCode) {
        assertNotNull("Response is null. The request step probably failed.", context.getResponse());
        context.getResponse().then().statusCode(statusCode);
    }


    @Then("the transaction status should be {string}")
    public void the_transaction_status_should_be(String expectedStatus) {

        String actualStatus =
                context.getResponse()
                        .jsonPath()
                        .getString("status");

        assertEquals(
                "Transaction status mismatch",
                expectedStatus,
                actualStatus
        );
    }
}