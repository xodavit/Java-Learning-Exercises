package ru.dns.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.dns.qa.BaseMethod;

import ru.dns.qa.VirtualProduct;

public class MainPage extends BaseMethod {
    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    WebElement searchInputField;
    @FindBy(id = "prod-card-buy-btn")
    WebElement addToBasketButton;
    @FindBy(xpath = "//a[@class='ui-link cart-link' and @data-commerce-target='CART']")
    WebElement goToBasketButton;

    public void addToBasket() {
        click(addToBasketButton);
    }
    public void goToBasket() {
        click(goToBasketButton);
    }


    public ResultsSearchPage searchProduct(VirtualProduct product) {
        click(searchInputField);
        sendText(searchInputField,product.getName());
        keyEnter(searchInputField);
        return new ResultsSearchPage();
    }
}
