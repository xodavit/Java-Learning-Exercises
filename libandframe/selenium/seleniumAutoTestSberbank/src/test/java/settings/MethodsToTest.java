package settings;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MethodsToTest extends SettingsToTest {
    protected void goToUrlPage(String url){
        getDRIVER().get(url);
        System.out.printf("Переход на сайт: %s\n",url);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//получение инфы
    protected String getFieldTextByXPath(String xPath){
        System.out.println(String.format("Получаем актуальное значение поля по xPath: %s",xPath));
        return getDRIVER().findElement(By.xpath(xPath)).getText();
    }
    protected String getFieldTextFromAttributeByXPath(String xPath,String attribute){
        System.out.println(String.format("Получаем актуальное значение поля по атрибуту(%s) xPath: %s",attribute,xPath));
        return getDRIVER().findElement(By.xpath(xPath)).getAttribute(attribute);
    }
    protected String getFieldTextById(String id){
        System.out.println(String.format("Получаем актуальное значение поля по id: %s",id));
        return getDRIVER().findElement(By.id(id)).getText();
    }
    protected String getFieldTextFromAttributeById(String id,String attribute){
        System.out.println(String.format("Получаем актуальное значение поля по атрибуту(%s) id: %s",attribute,id));
        return getDRIVER().findElement(By.id(id)).getAttribute(attribute);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //клики и переходы
    protected void clickByXPath(String xPath){
        getDRIVER().findElement(By.xpath(xPath)).click();
        System.out.println(String.format("Делаем клик по полученному xPAth %s", xPath));
    }
    protected void clickById(String id) {
        getDRIVER().findElement(By.id(id)).click();
        System.out.println(String.format("Делаем клик по полученному ID %s", id));
    }
    protected void sendTextByXPath(String xPath, String text){
        getDRIVER().findElement(By.xpath(xPath)).sendKeys(text);
        System.out.println(String.format("По xPath ссылке (%s) введены данные: %s.",xPath, text));
    }
    protected void sendTextById(String id, String text) {
        getDRIVER().findElement(By.id(id)).sendKeys(text);
        System.out.println(String.format("Вводим данные %s, по полученному ID %s",text, id));
    }
    protected void sendTextAndClickByXPath(String xPath, String text){
        clickByXPath(xPath);
        sendTextByXPath(xPath, text);
    }
    protected void sendTextAndClickById(String id, String text) {
        clickById(id);
        sendTextById(id, text);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ожидания
    protected void waitPresentByXPath(String xPath){
        System.out.println("Ожидание проверки наличия элемента на странице");
        getWAIT().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        System.out.println("Ожидание проверки прошло успешно");
    }

    protected void waitVisibleByXPath(String xPath){
        System.out.println("Ожидание проверки элемента, что он виден");
        getWAIT().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        System.out.println("Ожидание проверки прошло успешно");
    }
    protected void waitVisibleById(String id){
        System.out.println(String.format("Ожидание проверки элемента по id %s, что он виден", id));
        getWAIT().until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        System.out.println("Ожидание проверки прошло успешно");
    }

    protected void waitClickableByXPath(String xPath){
        System.out.println("Ожидание проверки элемента по xPath, что он виден и кликабелен");
        getWAIT().until(ExpectedConditions.elementToBeClickable(getDRIVER().findElement(By.xpath(xPath))));
        System.out.println("Ожидание проверки прошло успешно");
    }
    protected void waitClickableById(String id){
        System.out.println(String.format("Ожидание проверки элемента по id %s, что он виден и кликабелен", id));
        getWAIT().until(ExpectedConditions.elementToBeClickable(getDRIVER().findElement(By.id(id))));
        System.out.println("Ожидание проверки прошло успешно");
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//проверки
    protected void checkEqualsByXPath(String expected, String actual, String message){
        Assertions.assertEquals(expected,actual,message);
        System.out.println(String.format("Проверка прошла успешно, %s = %s",expected,actual));
    }
    protected void checkEqualsById(String expected, String actual, String message){
        Assertions.assertEquals(expected,actual,message);
        System.out.println(String.format("Проверка прошла успешно, %s = %s",expected,actual));
    }
    protected void checkTrueByXPath(String xPath, String message){
        Assertions.assertTrue(isDisplayedByXpath(xPath),message);
        System.out.println(String.format("Проверка прошла успешно"));
    }
    protected void checkTrueById(String id, String message){
        Assertions.assertTrue(isDisplayedById(id),message);
        System.out.println(String.format("Проверка прошла успешно"));
    }
    protected boolean isDisplayedByXpath(String xPath){
        System.out.println(String.format("отображается"));
        return getDRIVER().findElement(By.xpath(xPath)).isDisplayed();

    }
    protected boolean isDisplayedById(String id){
        System.out.println(String.format("отображается"));
        return getDRIVER().findElement(By.id(id)).isDisplayed();
    }
    //TODO сделать реализацию

    protected void checkEqualsByXPathAndAttribute(String expected, String xPath, String attribute, String message){
        Assertions.assertEquals(expected,getFieldTextFromAttributeByXPath(xPath,attribute),message);
    }
    protected void checkEqualsByIdAndAttribute(String expected, String id, String attribute, String message){
        Assertions.assertEquals(expected,getFieldTextFromAttributeById(id,attribute),message);
    }
}
