package com.car.api.services;

import com.car.api.builders.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private final String baseUrl;

    public ApiClient() {
        this.baseUrl = Config.BASE_URL;
        RestAssured.baseURI = baseUrl;
    }

    // =========================
    // 🔹 GET REQUEST
    // =========================
    public Response get(String endpoint) {
        return given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    // =========================
    // 🔹 POST REQUEST
    // =========================
    public Response post(String endpoint, Object body) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    // =========================
    // 🔹 PUT REQUEST
    // =========================
    public Response put(String endpoint, Object body) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    // =========================
    // 🔹 PATCH REQUEST
    // =========================
    public Response patch(String endpoint, Object body) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    // =========================
    // 🔹 DELETE REQUEST
    // =========================
    public Response delete(String endpoint) {
        return given()
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}