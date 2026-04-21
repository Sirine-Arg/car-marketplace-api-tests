package com.car.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {

    public static RequestSpecification requestSpec;

    @BeforeAll
    public static void globalSetup() {
        System.out.println("=== Test Suite Started ===");
    }

    @Before
    public void setUp() {

        RestAssured.baseURI =
                "https://0100f347-df11-476e-b872-aaa382f693eb.mock.pstmn.io";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .addHeader("Content-Type", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpec;

        System.out.println("=== Scenario started ===");
    }

    @After
    public void tearDown(Scenario scenario) {

        Allure.addAttachment("Scenario", scenario.getName());

        if (scenario.isFailed()) {
            System.out.println("❌ Scenario failed: " + scenario.getName());
        } else {
            System.out.println("✅ Scenario passed: " + scenario.getName());
        }

        System.out.println("=== Scenario ended ===");
    }
}