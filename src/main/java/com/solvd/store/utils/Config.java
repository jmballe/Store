package com.solvd.store.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public final class Config {

    public static final String DRIVER;
    public static final String URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        DRIVER = getValueFromConfig("DRIVER");
        URL = getValueFromConfig("URL");
        USERNAME = getValueFromConfig("USERNAME");
        PASSWORD = getValueFromConfig("PASSWORD");
    }

    private static String getValueFromConfig(String forVariable) {
        File fromFile = new File("./config.properties");
        String value = null;
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("./config.properties"));
            Properties property = new Properties();
            property.load(inputStream);
            value = property.getProperty(forVariable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}