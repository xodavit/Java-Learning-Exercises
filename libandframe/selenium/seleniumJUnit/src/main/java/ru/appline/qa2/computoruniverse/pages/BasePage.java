package ru.appline.qa2.computoruniverse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.qa2.computoruniverse.Init;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@class='cart-label']")
    WebElement goToBasketButton;

    public BasePage(){
        driver = Init.getDriver();
        wait = new WebDriverWait(driver, 3);
        PageFactory.initElements(driver, this);
    }


    public WebElement waitElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void goToBasket(){
        waitElementClickable(goToBasketButton).click();
    }
}
