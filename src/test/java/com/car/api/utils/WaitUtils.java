package com.car.api.utils;

import java.time.Duration;
import java.util.concurrent.Callable;

import static org.awaitility.Awaitility.await;

public class WaitUtils {

    public static void waitUntilTrue(Callable<Boolean> condition, int timeoutSeconds) {

        await()
                .atMost(Duration.ofSeconds(timeoutSeconds))
                .pollInterval(Duration.ofSeconds(2))
                .ignoreExceptions()
                .until(condition);
    }
}