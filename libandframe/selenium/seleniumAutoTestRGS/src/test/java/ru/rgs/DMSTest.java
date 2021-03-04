package ru.rgs;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import settings.WebDriverSettings;


public class DMSTest extends WebDriverSettings  {


    @Test
    public void notValidMailTest(){

        //1. Перейти по ссылке http://www.rgs.ru
        driver.get(URL_RGS);

        //2. Выбрать Меню
        String linkXpathMenuNavButton = "//a[@href='#' and @data-toggle='dropdown' and @class='hidden-xs']";
        driver.findElement(By.xpath(linkXpathMenuNavButton)).click();
        System.out.println("Выбрано выпадающее меню");

        //3. Выбрать категорию - ДМС
        String linkXpathDMS = "//a[contains(text(),'ДМС')]";
            //ожидание проверки элемента, что он виден и включен, для того что бы была возможность кликнуть по нему
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXpathDMS)));
        driver.findElement(By.xpath(linkXpathDMS)).click();
        System.out.println("Выбрана категория ДМС");

        //4. Проверить наличие заголовка - Добровольное
        //медицинское страхование
        String linkXpathHeadingH1 = "//h1[@class='content-document-header']";
            //ожидание проверки наличия элемента в DOM страницы
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkXpathHeadingH1)));
            //проверка соответствия
        String expectedTextInHeadingH1 = "ДМС — добровольное медицинское страхование";
        String actualTextFromHeadingH1 = driver.findElement(By.xpath(linkXpathHeadingH1)).getText();
        Assert.assertEquals("Текст заголовка не соответствует ожидаемому",
                expectedTextInHeadingH1,actualTextFromHeadingH1);
        System.out.println("Проверка соответствия заголовков прошла успешно");

        //5. Нажать на кнопку - Отправить заявку
        String linkXpathButtonToSendRequest = "//a[contains(text(),'Отправить заявку')]";
            //ожидание проверки элемента, что он виден и включен, для того что бы была возможность кликнуть по нему
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXpathButtonToSendRequest)));
        driver.findElement(By.xpath(linkXpathButtonToSendRequest)).click();
        System.out.println("Нажата кнопка - Отправить заявку");

        //6. Проверить, что открылась страница , на которой
        //присутствует текст - Заявка на добровольное
        //медицинское страхование
        String linkXpathFormWithContent = "//div[@class='modal-content']";
        //    //ожидание проверки наличия элемента в DOM страницы
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkXpathFormWithContent))); //нуэно ли оно тут?
            //Ожидание для проверки того, что элемент, известный как присутствующий в DOM страницы, является видимый.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXpathFormWithContent)));
            //проверка соответствия
        //тут переодически выскакивает ошибка
        String expectedTextInHeadTitleRequest = "Заявка на добровольное медицинское страхование";
        String linkXpathTextHeadTitleRequest = "//b[@data-bind='text: options.title']";
        String actualTextFromHeadTitleRequest = driver.findElement(By.xpath(linkXpathTextHeadTitleRequest)).getText();
        Assert.assertEquals("Текст заголовка не соответствует ожидаемому",
                expectedTextInHeadTitleRequest,actualTextFromHeadTitleRequest);
        System.out.println("Проверка соответствия заголовков прошла успешно");

        //7.Заполнить поля
        //Имя, Фамилия, Отчество, Регион, Телефон,
        //Эл. почта - qwertyqwerty,
        //Комментарии, Я согласен на обработку

            //Имя
        String linkXpathFieldFirstName = "//input[@name='FirstName']";
        String firstName = "Джон";
        driver.findElement(By.xpath(linkXpathFieldFirstName)).sendKeys(firstName);
            // Фамилия
        String linkXpathFieldLastName = "//input[@name='LastName']";
        String lastName = "Сноу";
        driver.findElement(By.xpath(linkXpathFieldLastName)).sendKeys(lastName);
            // Отчество
        String linkXpathFieldMiddleName = "//input[@name='MiddleName']";
        String middleName = "Бастардович";
        driver.findElement(By.xpath(linkXpathFieldMiddleName)).sendKeys(middleName);
            // Регион
        String linkXpathFieldSelectRegion = "//select[@name='Region']";
        String region = "Москва";
        driver.findElement(By.xpath(linkXpathFieldSelectRegion)).click();
        String linkXpathRegion = "//option[@value='77']";
            //ожидание проверки элемента, что он виден и включен, для того что бы была возможность кликнуть по нему
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXpathFieldSelectRegion)));
        driver.findElement(By.xpath(linkXpathRegion)).click();
            // Телефон
        String linkXpathFieldPhone = "//label[contains(text(),'Телефон')]//following-sibling::input";
        String phone = "9991234567";
        driver.findElement(By.xpath(linkXpathFieldPhone)).click();
        driver.findElement(By.xpath(linkXpathFieldPhone)).sendKeys(phone);
            //Эл. почта
        String linkXpathFieldEmail = "//input[@name='Email']";
        String notValidEmail = "qwertyqwerty";
        driver.findElement(By.xpath(linkXpathFieldEmail)).sendKeys(notValidEmail);
            //Комментарии
        String linkXpathFieldComment = "//textarea[@name='Comment']";
        String comment = "comment4y";
        driver.findElement(By.xpath(linkXpathFieldComment)).sendKeys(comment);
            //согласие на обработку
        String linkXpathCheckboxAssept = "//input[@type='checkbox']";
        driver.findElement(By.xpath(linkXpathCheckboxAssept)).click();
            //предпочитаемая дата контакта
        String linkXpathFieldContactDate = "//input[@name='ContactDate']";

        System.out.println("Данные формы заполнены");
        //8. Проверить, что все поля заполнены
        //введенными значениями
        String valueAttribute = "value";

        String actualFirstName = driver.findElement(By.xpath(linkXpathFieldFirstName)).getAttribute(valueAttribute);
        Assert.assertEquals("Имя не совпадает", firstName, actualFirstName);

        String actualLastName = driver.findElement(By.xpath(linkXpathFieldLastName)).getAttribute(valueAttribute);
        Assert.assertEquals("Фамилия не совпадает", lastName, actualLastName);

        String actualMiddleName = driver.findElement(By.xpath(linkXpathFieldMiddleName)).getAttribute(valueAttribute);
        Assert.assertEquals("Отчество не совпадает", middleName, actualMiddleName);

        String actualRegionCode = driver.findElement(By.xpath(linkXpathFieldSelectRegion)).getAttribute(valueAttribute);
        String linkXpathActualRegion = linkXpathFieldSelectRegion+
                "//following-sibling::option[@value='" + actualRegionCode + "']";

        String actualRegion = driver.findElement(By.xpath(linkXpathActualRegion)).getText();

        Assert.assertEquals("Регион не совпадает",region,actualRegion);

        String actualPhone = driver.findElement(By.xpath(linkXpathFieldPhone)).getAttribute(valueAttribute)
                .replaceAll("\\p{Punct}|\\p{Space}", "")
                .replaceAll("\\A[7]","");
        Assert.assertEquals("Телефон не совпадает",phone,actualPhone);

        String actualEmail = driver.findElement(By.xpath(linkXpathFieldEmail)).getAttribute(valueAttribute);
        Assert.assertEquals("Почта не совпадает", notValidEmail, actualEmail);

        String actualComment = driver.findElement(By.xpath(linkXpathFieldComment)).getAttribute(valueAttribute);
        Assert.assertEquals("Комментарий не совпадает", comment, actualComment);

        System.out.println("Данные формы проверены на заполненность");

        //9. Нажать Отправить
        String linkXpathButtonSend = "//div[@class='form-footer']//button[@type='button']";
        driver.findElement(By.xpath(linkXpathButtonSend)).click();
        System.out.println("Нажата кнопка отправить");


        //10. Проверить, что у Поля - Эл. почта
        //присутствует сообщение об ошибке -
        //Введите корректный email

        String linkXpathErrorFieldEmail = "//input[@name='Email']/..//div[@class='validation-group-error-wrap']" +
                "//label[@class='validation-error']//span[@class='validation-error-text']";
            //Ожидание для проверки того, что элемент, известный как присутствующий в DOM страницы, является видимый.
            // без этого, не проходила проверка видимости надписи :(
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXpathErrorFieldEmail)));
        String actualTextErrorFromEmailField = driver.findElement(By.xpath(linkXpathErrorFieldEmail)).getText();
        System.out.println(actualTextErrorFromEmailField);
        String textEmailError = "Введите адрес электронной почты";
        Assert.assertEquals("Поле Почты не содержит сообщения об ошибке",
                textEmailError,actualTextErrorFromEmailField);
        System.out.println("сообщение об ошибке было получено");
    }







}
