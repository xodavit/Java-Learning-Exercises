package ru.dns.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns.qa.BaseMethod;
import ru.dns.qa.VirtualBasket;
import ru.dns.qa.VirtualProduct;

public class ProductPage extends BaseMethod {


    @FindBy(xpath = "//span[@class='current-price-value']")
    private WebElement productPriceTextField;
    @FindBy(xpath = "//h1[@data-product-param='name']")
    private WebElement productNameTextField;
    @FindBy(xpath = "//div[@class='price-item-description']//p")
    private WebElement productDescriptionTextField;

    public WebElement getProductPrice() {
        return productPriceTextField;
    }

    public WebElement getProductName() {
        return productNameTextField;
    }

    public WebElement getProductDescription() {
        return productDescriptionTextField;
    }

    public void addToVirtualBasket(){
        String name = getProductName().getText();
        int price = Integer.parseInt(getProductPrice().getText().replaceAll(" ",""));
        String description = getProductDescription().getText();
        VirtualProduct product = new VirtualProduct(name,price,description);
        VirtualBasket.addToBasket(product);
    }
    public void getInfo() {
        System.out.println(productNameTextField.getText());
        System.out.println(productPriceTextField.getText());
        System.out.println(productDescriptionTextField.getText());
    }



}
