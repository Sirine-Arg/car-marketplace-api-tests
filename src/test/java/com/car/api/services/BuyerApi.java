package com.car.api.services;

import com.car.api.constants.Endpoints;
import com.car.api.pojoModels.Buyer;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuyerApi {
    // =========================
    // CREATE BUYER
    // =========================
    public Response createBuyer(Buyer buyer) {

        return given()
                .contentType("application/json")
                .body(buyer)
                .when()
                .post(Endpoints.CREATE_BUYER);
    }

    // =========================
    // GET BUYER BY ID
    // =========================
    public Response getBuyerById(String buyerId) {

        return given()
                .pathParam("id", buyerId)
                .when()
                .get("/GetBuyer/{id}");
    }

    // =========================
    // GET ALL BUYERS (optional)
    // =========================
    public Response getAllBuyers() {

        return given()
                .when()
                .get("/GetAllBuyers");
    }

}
