import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExampleScenarioTest extends  SettingsTest{

    @Test
    public void exampleTest(){

        driver.get("https://www.sberbank.ru/ru/person");

        String regionLinkXpath = "//div[contains(@class, 'paste-region__region header__region')]//a[@class='hd-ft-region']";
        WebElement regionLinkElement = driver.findElement(By.xpath(regionLinkXpath));
        //List<WebElement> linkElements = driver.findElements(By.xpath("//a[@class='hd-ft-region']"));
        regionLinkElement.click();

        String concreteRegionXpath = "//a[contains(text(),'Нижегородская область')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(concreteRegionXpath)));// неявное ожидание
        driver.findElement(By.xpath(concreteRegionXpath)).click();

        Assert.assertEquals("Ссылки не соответствую ожиданию",
                "Нижегородская область",
                driver.findElement(By.xpath("//div[contains(@class, 'paste-region__region header__region')]//a[@class='hd-ft-region']//span")).getText());



        String footerTag = "footer";
        WebElement footerElement = driver.findElement(By.tagName(footerTag));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",footerElement);
        wait.until(ExpectedConditions.visibilityOf(footerElement));

        WebElement fblogo = driver.findElement(By.xpath("//a[@title='Поделиться в Facebook']"));
        Assert.assertTrue("Элемент отсутствует на странице",fblogo.isDisplayed());

    }
    @Test
    public void exampleTest2() throws InterruptedException {
        int sum = 1+1;
        Assert.assertEquals("Неверный результат сложнения",3,sum);
        //Thread.sleep(2000); // не стоит тормозить потоки
        //driver.wait(20000); //не работает

    }

}
