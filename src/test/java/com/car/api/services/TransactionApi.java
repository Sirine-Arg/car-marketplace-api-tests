package com.car.api.services;

import com.car.api.pojoModels.Transaction;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TransactionApi {

    public Response createTransaction(Transaction transaction) {

        return given()
                .contentType("application/json")
                .body(transaction)
                .when()
                .post("/CreateTransaction");

    }

    public Response getTransactionById(String transactionId) {

        return given()
                .pathParam("id", transactionId)
                .when()
                .get("/GetTransaction/{Id}");
    }

}
