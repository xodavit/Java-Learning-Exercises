package ru.appline.qa2.computoruniverse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(){
        waitElementClickable(titlesElements.get(0));
    }


    final String resultsBaseXpath = "//*[contains(@class,'product-display')]";

    @FindBy(xpath = "//*[contains(@class,'productListItemTitle')]")
    List<WebElement> titlesElements;


    final String itemTitleTemplate="//*[contains(@class,'productListItemTitle') and contains(.,'%s')]";




    public void chooseByPartialName(String name){
        long start = System.currentTimeMillis();
        System.out.println();
        titlesElements.stream()
                .map(WebElement::getText)
                .filter(text->text.contains(name))
                .findFirst().get();
        long end = System.currentTimeMillis();
        System.out.println("Выполнено за "+(end-start)+" ms");

    }

    public void chooseByPartialNameFast(String name){
        long start = System.currentTimeMillis();
        System.out.println();
        By locator = By.xpath(String.format(itemTitleTemplate, name));
        driver.findElement(locator).click();
        long end = System.currentTimeMillis();
        System.out.println("Выполнено за "+(end-start)+" ms");
    }
}
