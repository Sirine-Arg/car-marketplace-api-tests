package com.car.api.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestDataReader {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String BASE_PATH = "testdata/";

    private TestDataReader() {}

    public static JsonNode load(String fileName) {
        try (InputStream is = TestDataReader.class.getClassLoader()
                .getResourceAsStream(BASE_PATH + fileName)) {

            if (is == null) {
                throw new IllegalStateException(
                        "Could not find test data file: " + BASE_PATH + fileName);
            }

            return MAPPER.readTree(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data JSON: " + fileName, e);
        }
    }

    public static String get(String fileName, String field) {

        JsonNode root = load(fileName);

        JsonNode value = root.get(field);

        if (value == null) {
            throw new IllegalArgumentException("Missing field: " + field);
        }

        return value.asText();
    }
}