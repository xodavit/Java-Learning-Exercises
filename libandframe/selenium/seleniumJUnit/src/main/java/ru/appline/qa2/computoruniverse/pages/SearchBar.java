package ru.appline.qa2.computoruniverse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends  BasePage{
    @FindBy(xpath = "//*[contains(@id,'search-input')]")
    WebElement searchInput;

    @FindBy(id = "serch-button")
    WebElement searchButton;


    public void search(String text) {
        waitElementClickable(searchInput).sendKeys(text);
        waitElementClickable(searchButton).click();
    }

}
