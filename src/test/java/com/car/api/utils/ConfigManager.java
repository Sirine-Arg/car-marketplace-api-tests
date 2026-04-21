package com.car.api.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {


        private static Properties properties = new Properties();

        static {
            String env = EnvironmentManager.getEnv();

            try (InputStream input =
                         ConfigManager.class.getClassLoader()
                                 .getResourceAsStream("config/" + env + ".properties")) {

                properties.load(input);

            } catch (Exception e) {
                throw new RuntimeException("Failed to load config for env: " + env);
            }
        }

        public static String get(String key) {
            return properties.getProperty(key);
        }
    }
