package ru.appline.qa2.computoruniverse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.qa2.computoruniverse.VirtualBasket;

public class BasketPage extends BasePage {
    @FindBy(xpath = "(//*[@value='Оформить заказ'])[last()]")
    WebElement readyField;


    @FindBy(xpath = "//*[contains(@class,'cart-totalprice')]")
    WebElement totalPriceField;

    public BasketPage(){
        waitElementClickable(readyField);
    }

    public Double getFactualPrice(){
        String factPirceText = waitElementClickable(totalPriceField).getAttribute("data-carttotalprice").replace(",","");
        Double factPrice = Double.parseDouble(factPirceText);
        return factPrice;
    }
}
