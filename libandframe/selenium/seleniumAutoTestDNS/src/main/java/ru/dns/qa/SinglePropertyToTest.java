package ru.dns.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SinglePropertyToTest {
    private final Properties properties = new Properties();
    private static SinglePropertyToTest INSTANCE = null;
    private SinglePropertyToTest(){
        try {
            properties.load(new FileInputStream(new File("drivers/properties/"
                    //+ System.getProperty("environment") + ".properties")));
                    +"chrome.properties")));
                    //+"opera.properties")));
                    //+"firefox.properties"))); //не заработал у меня


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //публичный метод получения
    public static SinglePropertyToTest getInstance() {
        if (INSTANCE == null){
            INSTANCE = new SinglePropertyToTest();
        }
        return INSTANCE;
    }
    public Properties getProperties() {
        return properties;
    }
}
