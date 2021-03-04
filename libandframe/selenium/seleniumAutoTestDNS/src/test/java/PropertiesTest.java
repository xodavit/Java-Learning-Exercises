import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dns.qa.SinglePropertyToTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    @DisplayName("чтение chrome.properties")
    void propertiesChromeTest(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(new File("drivers/properties/chrome.properties")));
        } catch(IOException e){
            throw new RuntimeException("не удалось найти файл! " + e.getMessage());
        }
        properties.forEach((key,value)-> {
            System.out.println(String.format("%s = %s", key, value));
        });
    }
    @Test
    @DisplayName("чтение firefox.properties")
    void propertiesFirefoxTest(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(new File("drivers/properties/firefox.properties")));
        } catch(IOException e){
            throw new RuntimeException("не удалось найти файл! " + e.getMessage());
        }
        properties.forEach((key,value)-> {
            System.out.println(String.format("%s = %s", key, value));
        });
    }
    @Test
    @DisplayName("чтение opera.properties")
    void propertiesOperaTest(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(new File("drivers/properties/opera.properties")));
        } catch(IOException e){
            throw new RuntimeException("не удалось найти файл! " + e.getMessage());
        }
        properties.forEach((key,value)-> {
            System.out.println(String.format("%s = %s", key, value));
        });
    }
    @Test
    @DisplayName("чтение текущей properties")
    void currentPropertyTest(){
        Properties properties;

        properties = SinglePropertyToTest.getInstance().getProperties();
        System.out.println("Текущие настройки:");
        properties.forEach((key,value)-> {
            System.out.println(String.format("%s = %s", key, value));
        });

    }

}
