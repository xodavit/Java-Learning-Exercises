package ru.appline.qa2.computoruniverse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Init class
 */
public class Init {
    private static WebDriver driver;

    public static void initWebdriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.computeruniverse.net/ru");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
