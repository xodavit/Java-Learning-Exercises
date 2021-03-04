package ru.dns.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns.qa.InitialWebDriver;


public class BaseMethod {
     private WebDriver driver;
     private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public BaseMethod() {
        driver = InitialWebDriver.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }
    public WebElement waitElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitElementClickable(element).click();
    }
    public void sendText(WebElement element, String text) {
        waitElementClickable(element).sendKeys(text);
    }
    public void keyEnter(WebElement element) {
        waitElementClickable(element).sendKeys(Keys.ENTER);
    }
}
