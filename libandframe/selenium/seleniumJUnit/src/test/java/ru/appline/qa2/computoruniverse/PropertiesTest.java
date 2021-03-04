package ru.appline.qa2.computoruniverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.appline.qa2.Init;
import ru.appline.qa2.OutTestProperties;
import ru.appline.qa2.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    @Test
    @Disabled
    void properties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/test/resources/env1.properties")));
        } catch (IOException e) {
            throw new RuntimeException("не удалось найти файл! " + e.getMessage());
        }
        properties.forEach((key, value) -> {
            System.out.println(String.format("%s - %s", key, value));
        });
        System.out.println(properties.getProperty("browser", "Chrome"));

    }
}

