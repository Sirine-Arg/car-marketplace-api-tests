package com.car.api.utils;

public class EnvironmentManager {
    public static String getEnv() {
        return System.getProperty("env", "mock"); // default = mock
    }
}
