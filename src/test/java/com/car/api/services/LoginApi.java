package com.car.api.services;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginApi {

    private static final String LOGIN_ENDPOINT = "/auth/login";

    public Map<String, Object> buildLoginPayload(String username, String password) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username ", username);

        if (password != null) {
            payload.put("password", password);
        }

        return payload;
    }

    public Response login(Map<String, Object> payload) {
        return given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .extract()
                .response();
    }
}