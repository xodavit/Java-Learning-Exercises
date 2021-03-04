package ru.dns.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns.qa.BaseMethod;

public class BasketPage extends BaseMethod {

    @FindBy(xpath = "//div[@data-commerce-target='basket_additional_warranty_24']//span")
    private WebElement selectWarranty24Month;

    @FindBy(xpath = "//button[@data-commerce-action='cart_remove_button']")
    private WebElement deleteFromBasketButton;
    @FindBy(xpath = "//a[contains(text(),'Вернуть удалённый товар')]")
    private WebElement restoreProduct;
    @FindBy(xpath = "//div[@data-cart-product-id][1]//*[@class='count-buttons__icon-plus']")
    WebElement buttonAddCountToBasket;
    @FindBy(xpath = "//div[@data-cart-product-id][2]//*[@class='count-buttons__icon-minus']")
    private WebElement buttonDecreaseCountFromCart;
    public  void addWarranty(){
        click(selectWarranty24Month);
    }
    public  void deleteFromBasket(){
        click(deleteFromBasketButton);
    }
    public void countAddInBasket() {
        click(buttonAddCountToBasket);
    }
}
