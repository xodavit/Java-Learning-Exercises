package ru.appline.qa2.computoruniverse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.qa2.computoruniverse.VirtualBasket;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'productpricevalue')]")
    WebElement productPriceTextField;

    @FindBy(tagName = "h1")
    WebElement productNameTextField;


    @FindBy(xpath = "(//*[@value='В корзину'])[1]")
    WebElement addToBasketButton;

    @FindBy(xpath = "//*[@id='WA_success']")
    WebElement successFlag;


    public void addToBaksetAndSaveToVirtualBasket(){
        String productNameText = waitElementClickable(productNameTextField).getText();
        String priceText = waitElementClickable(productPriceTextField).getAttribute("data-productpricevalue").replace(",","");
        Double price = Double.parseDouble(priceText);
        VirtualBasket.addToBasket(productNameText, price);
        waitElementClickable(addToBasketButton).click();
        waitElementClickable(successFlag);
    }
}
