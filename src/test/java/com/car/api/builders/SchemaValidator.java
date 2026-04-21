package com.car.api.builders;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidator {

    public static void validate(Response response, String schemaFileName) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(
                        "schemas/" + schemaFileName + ".json"
                ));
    }

}
