package com.solvd.store.utils;

import java.io.IOException;
import java.util.Properties;

public enum Config {
    DRIVER, USER, PASS, URL;

    private String value;

    static {
        try {
            Properties properties = new Properties();
            properties.load(Config.class.getClassLoader().getResourceAsStream("dbConfig.properties"));
            DRIVER.value = properties.getProperty(DRIVER.toString().toLowerCase());
            USER.value = properties.getProperty(USER.toString().toLowerCase());
            PASS.value = properties.getProperty(PASS.toString().toLowerCase());
            URL.value = properties.getProperty(URL.toString().toLowerCase());
        } catch (IOException e) {
            System.err.println("Could not get properties.");
        }
    }

    public String getValue() {
        return this.value;
    }

    Config() {
    }
}