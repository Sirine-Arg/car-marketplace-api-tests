package com.car.api.services;

import com.car.api.constants.Endpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarsApi {

    // =========================
    // GET ALL CAR LISTINGS
    // =========================
    public Response getAllListings() {

        return given()
                .when()
                .get(Endpoints.GET_ALL_LISTINGS);
    }

    // =========================
    // GET LISTING BY ID
    // =========================
    public Response getListingById(String listingId) {

        return given()
                .pathParam("id", listingId)
                .when()
                .get("/GetListing/{id}");
    }

    // =========================
    // DELETE LISTING (optional)
    // =========================
    public Response deleteListing(String listingId) {

        return given()
                .pathParam("id", listingId)
                .when()
                .delete("/DeleteListing/{id}");
    }

}
