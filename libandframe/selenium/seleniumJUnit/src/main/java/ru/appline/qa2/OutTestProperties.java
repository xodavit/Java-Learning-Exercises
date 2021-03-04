package ru.appline.qa2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OutTestProperties {
    private final Properties properties = new Properties();
    private static OutTestProperties INSTANCE = null;
    private OutTestProperties(){
        try {
            properties.load(new FileInputStream(new File("src/test/resources/"
                    + System.getProperty("environment") + ".properties")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //публичный метод получения
    public static OutTestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new OutTestProperties();
        }
        return INSTANCE;
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
    public Properties getProperties() {
        return properties;
    }
}
