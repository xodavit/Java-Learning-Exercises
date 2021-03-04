package ru.appline.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;
@Disabled
public class BaseSeleniumTest {

    WebDriver driver;
    String insuranceXpath = "//";

    //Map<String,String> fields = Map.of("Ссылка","//"); //max 15 elem.
    Map <String,String> fields;

    @BeforeEach
    void initDriver(){
        String browser = System.getProperty("browser","chrome");
        switch (browser) {
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        goToUrl("string URL");
    }
    @AfterEach
    void quitDriver(){
        driver.quit();
    }
    public void goToUrl(String url){
         driver.get(url);
    }
    public void findFieldAndClick(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public String getFieldText(String xpath){
        String text = driver.findElement(By.xpath(xpath)).getText();
        return text;
    }
    public void clickField(String name) {
        String xpath = fields.get(name);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void waitElement(String xpath) {
        new WebDriverWait(driver, 5)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

}
