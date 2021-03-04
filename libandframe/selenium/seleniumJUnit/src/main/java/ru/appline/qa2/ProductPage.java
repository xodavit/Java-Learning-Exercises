package ru.appline.qa2;

import org.openqa.selenium.WebElement;

public class ProductPage {
    WebElement productPrice;

    public void addCurrentProductToBasket(){

        Basket basket = new Basket();//get current basket
        basket.totalPrice+= Double.parseDouble(productPrice.getText());
    }
}
