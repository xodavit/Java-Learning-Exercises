package ru.dns.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Init class
 */
public class InitialWebDriver {
    private static WebDriver driver;
    public static Properties properties = SinglePropertyToTest.getInstance().getProperties();
    private static String URL = properties.getProperty("app.url");

    public static void initialWebDriver(){
        switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", properties.getProperty("webdriver.opera.driver"));
                driver = new OperaDriver();
                break;
            default:
                throw new RuntimeException("Браузер не выбран");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
    }
}
