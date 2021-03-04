package ru.appline.qa2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    void isOk(){
        Assertions.assertEquals(4,2+2);
    }
    @Test
    void properties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/test/resources/env1.properties")));
        } catch (IOException e) {
            throw new RuntimeException("не удалось найти файл! "+e.getMessage());
        }
        properties.forEach((key,value)->{
            System.out.println(String.format("%s - %s",key,value));
        });
        System.out.println(properties.getProperty("browser","Chrome"));
    }
    @Test
    void propertiesSingleton(){

        System.out.println(OutTestProperties.getInstance().getProperty("browser"));
    }
    @Test
    void loginPageTest(){
        new LoginPage().login("vasya","qwerty")
                .createTestDocument();
    }
    @Test
    void searchPageTest(){
        YandexMainPage start = new YandexMainPage(Init.driver); //driver
        start.search("bla-bla");
    }
    @Test
    void BaseObjectTest(){
        new ChildClass();
    }
}
