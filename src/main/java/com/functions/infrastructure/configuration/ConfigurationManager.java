package com.functions.infrastructure.configuration;

import com.functions.domain.exception.MisconfigurationException;

import java.util.List;
import java.util.Properties;

public class ConfigurationManager {

    private static ConfigurationManager instance = null;
    private final Properties properties;

    public ConfigurationManager() throws MisconfigurationException {
        properties = new Properties();

        for (String mandatoryKey : extractKeys()) {
            String value = System.getenv(mandatoryKey);
            if (value == null) {
                throw new MisconfigurationException(String.format("[%s]: Undefined environment variable", mandatoryKey));
            }
            properties.setProperty(mandatoryKey, value);
        }
    }

    public static ConfigurationManager getInstance() throws MisconfigurationException {
        if( instance == null ) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private List<String> extractKeys() {
        return List.of("GEMINI_API_KEY", "GEMINI_URL");
    }
}
