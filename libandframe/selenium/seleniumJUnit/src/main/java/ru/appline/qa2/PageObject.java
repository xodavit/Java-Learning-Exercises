package ru.appline.qa2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends  BasePage {
    WebDriver driver;
    @FindBy(xpath= "//*[@class='page-header']/*")
    public WebElement title;
    @FindBy(xpath= "//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]")
    public WebElement sendAppBtn;

    public PageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver= driver;
    }
    public void goToSendAppPage(){
        sendAppBtn.click();
    }
}
