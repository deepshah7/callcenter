package com.callcenter.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class ApplicationProperties {

    private static ApplicationProperties instance;

    private final Properties properties = new Properties();

    static {
        instance = new ApplicationProperties();
        instance.loadProperties();
    }

    private void loadProperties() {
        try {
            properties.load(new ClassPathResource("app.properties").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ApplicationProperties() {

    }

    public String get(final String key) {
        return properties.getProperty(key);
    }

    public static ApplicationProperties getInstance() {
        return instance;
    }

}
