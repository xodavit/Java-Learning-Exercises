package ru.dns.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns.qa.BaseMethod;

public class ProductName extends BaseMethod {
    @FindBy(xpath = "//a[contains(text(),'PlayStation 4 Slim Black')]")
    public WebElement ps4;
    @FindBy(xpath = "//a[contains(text(),'Detroit')]")
    public WebElement detroit;

    @FindBy(xpath = "//div[contains(text(),'1626724')]/parent::div/parent::div/parent::div//span[@class='price__current']")
    WebElement productPricePlaystaition;
    @FindBy(xpath = "//div[contains(text(),'1225442')]/parent::div/parent::div/parent::div//span[@class='price__current']")
    WebElement productPriceDetroit;

}
