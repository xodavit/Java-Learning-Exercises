package ru.appline.qa2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = Init.driver;
        PageFactory.initElements(driver,this);
    }

    public void clickButton(){
        WebElement button = driver.findElement(By.xpath("//"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        //сначала будет клик по хпассу, а только потом ожидание. так ненадо делать!
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//")))); //ГРАБЛИ
        //лучше использовать ожидания, которые принимают локаторы
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//")));
        //когда pageObject не дожидается элемента,  выставляем неявное ожидание побольше секунд на 5, а потом ждем отображения
    }
}
