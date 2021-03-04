package ru.dns.qa.pages;

import org.openqa.selenium.WebElement;
import ru.dns.qa.BaseMethod;



public class ResultsSearchPage extends BaseMethod {



    public ProductPage chooseProduct(WebElement element) {
        click(element);
        return new ProductPage();
    }
}
