package ru.appline.qa2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexMainPage extends  BasePage{
    @FindBy(xpath = "//div[contains(@class, 'search')]//input[@id='text']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[contains(@class, 'search')]//*[text()='Найти']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[contains(@class, 'search')]//*[text()='Найти']")
    private List<WebElement> searchButtonCollections;

    public YandexMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        //PageFactory.initElements(driver,YandexMainPage.class);
    }
    public void search(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }
}
