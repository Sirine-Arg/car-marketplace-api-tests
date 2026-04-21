package com.car.api.services;

import com.car.api.pojoModels.Listing;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ListingApi {


    // ===== CREATE LISTING =====
    public Response createNewCarListing(Listing listing) {

        return given()
                .contentType(ContentType.JSON)
                .body(listing)
                .when()
                .post("/CreateListing");
    }


    // ===== GET ALL LISTINGS =====
    public Response getAllListings(String endpoint) {

        return given()
                .when()
                .get("/GetAllListings");
    }


    // ===== GET LISTING BY ID =====
    public Response getListingById(String listingId) {

        return given()
                .contentType(ContentType.JSON)
                .pathParam("id", listingId)
                .when()
                .get("/GetListing/{id}");
    }
}
