package sberbank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import settings.MethodsToTest;
import static sberbank.data.TestingDataSB.*;

@DisplayName("Проверка физ лиц")

public class SberbankPeopleTest extends MethodsToTest {

    //@RepeatedTest(3)
    @DisplayName("Проверка страхования путешествий")
    @ParameterizedTest(name = "Проверка с данными: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}.")
    @MethodSource("sberbank.data.TestingDataSB#personData")
    void travelInsuranceSBTest(String surNameZ, String nameZ, String dateBirthday, String lastName, String name, String middleName, String sex, String passportSerial, String passportNumber, String passportDate, String passportIssued){
        System.out.println(String.format("Данные получены: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s.",surNameZ, nameZ, dateBirthday, lastName, name, middleName, sex, passportSerial, passportNumber, passportDate, passportIssued));

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        goToUrlPage(URL_SB_MAIN_PAGE);
        //2. Нажать на –Страхование
        clickByXPath(LINK_XPATH_INSURANCE_IN_MAIN_PAGE);
        //3. Выбрать –Путешествие и покупки
        clickByXPath(LINK_XPATH_INSURANCE_TRAVEL_IN_MAIN_PAGE);
        //4. Проверить наличие на странице заголовка –Страхование путешественников
        //TODO починить проверку

        //checkTrueByXPath(LINK_XPATH_TITLE_TEXT_INSURANCE_TRAVEL,"Заголовка на странице не обнаружено");
        //checkEqualsByXPathAndAttribute(EXPECTED_TEXT_INSURANCE_TRAVEL,LINK_XPATH_TITLE_TEXT_INSURANCE_TRAVEL,ATTRIBUTE_VALUE,"Заголовка на странице не обнаружено");
        //5. Нажать на –Оформить Онлайн
        //пункт 5 работает не всегда
        //кто сообразит, что нужно загуглить чтобы работало и сделает, тот молодец
        //причем, такая штука в реальных проектах встречается часто
        //TODO разобраться как нормально закрыть куки, чтоб заработало ожидание кликабельности
        clickByXPath(LINK_XPATH_BUTTON_REGISTRATION_INSURANCE_ONLINE);
        //6. На вкладке –Выбор полиса выбрать сумму страховой защиты –Минимальная


        clickByXPath(LINK_XPATH_MIN_INSURANCE);
        //7. Нажать Оформить
        waitClickableByXPath(LINK_XPATH_BUTTON_REGISTRATION_INSURANCE);
        clickByXPath(LINK_XPATH_BUTTON_REGISTRATION_INSURANCE);

        //8. На вкладке Оформить заполнить поля:
        //Фамилию
        waitVisibleById(ID_FIELD_PERSON_SURNAME_Z);

        clickById(ID_FIELD_PERSON_SURNAME_Z);
        sendTextById(ID_FIELD_PERSON_SURNAME_Z,surNameZ);
        //Имя
        clickById(ID_FIELD_PERSON_NAME_Z);
        sendTextById(ID_FIELD_PERSON_NAME_Z,nameZ);
        //Дату рождения застрахованных
        clickById(ID_FIELD_PERSON_BIRTH_DATE_Z);
        sendTextById(ID_FIELD_PERSON_BIRTH_DATE_Z,dateBirthday);
        //• Данные страхователя:
        //Фамилия

        clickById(ID_FIELD_PERSON_SURNAME);
        sendTextById(ID_FIELD_PERSON_SURNAME,lastName);
        // Имя
        clickById(ID_FIELD_PERSON_NAME);
        sendTextById(ID_FIELD_PERSON_NAME,name);

        // Отчество
        clickById(ID_FIELD_PERSON_MIDDLE_NAME);
        sendTextById(ID_FIELD_PERSON_MIDDLE_NAME,middleName);
        // Дата рождения
        clickById(ID_FIELD_PERSON_BIRTH_DATE);
        sendTextById(ID_FIELD_PERSON_BIRTH_DATE,dateBirthday);
        // Пол
        //TODO выбор пола
        //Паспортные данные
        //серия
        clickById(ID_FIELD_PERSON_PASSPORT_SERIES);
        sendTextById(ID_FIELD_PERSON_PASSPORT_SERIES,passportSerial);
        //номер
        clickById(ID_FIELD_PERSON_PASSPORT_NUMBER);
        sendTextById(ID_FIELD_PERSON_PASSPORT_NUMBER,passportNumber);
        //дата выдачи
        clickById(ID_FIELD_PERSON_PASSPORT_DATE);
        sendTextById(ID_FIELD_PERSON_PASSPORT_DATE,passportDate);
        //кем выдан
        clickById(ID_FIELD_PERSON_PASSPORT_ISSUE);
        sendTextById(ID_FIELD_PERSON_PASSPORT_ISSUE, passportIssued);
        //Контактные данные не заполняем

        //9. Проверить, что все поля заполнены правильно
        checkEqualsByIdAndAttribute(surNameZ,ID_FIELD_PERSON_SURNAME_Z,ATTRIBUTE_VALUE,"Фамилия загранпаспорта не совпадает");
        checkEqualsByIdAndAttribute(nameZ,ID_FIELD_PERSON_NAME_Z,ATTRIBUTE_VALUE,"Имя загранпаспорта не совпадает");
        checkEqualsByIdAndAttribute(dateBirthday,ID_FIELD_PERSON_BIRTH_DATE_Z,ATTRIBUTE_VALUE," Дата рождения в загранке не совпадает");
        checkEqualsByIdAndAttribute(lastName,ID_FIELD_PERSON_SURNAME,ATTRIBUTE_VALUE,"Фамилия не совпадает");
        checkEqualsByIdAndAttribute(name,ID_FIELD_PERSON_NAME,ATTRIBUTE_VALUE,"Имя не совпадает");
        checkEqualsByIdAndAttribute(middleName,ID_FIELD_PERSON_MIDDLE_NAME,ATTRIBUTE_VALUE,"Отчество не совпадает");
        checkEqualsByIdAndAttribute(dateBirthday,ID_FIELD_PERSON_BIRTH_DATE,ATTRIBUTE_VALUE,"День Рождения не совпадает");
        checkEqualsByIdAndAttribute(passportSerial,ID_FIELD_PERSON_PASSPORT_SERIES,ATTRIBUTE_VALUE,"Серия паспорта не совпадает");
        checkEqualsByIdAndAttribute(passportNumber,ID_FIELD_PERSON_PASSPORT_NUMBER,ATTRIBUTE_VALUE,"Номер паспорта не совпадает");
        //TODO какого хрена дата не совпадает
        //checkEqualsByIdAndAttribute(passportDate,ID_FIELD_PERSON_PASSPORT_DATE,ATTRIBUTE_VALUE,"Дата в паспорте не совпадает");
        checkEqualsByIdAndAttribute(passportIssued,ID_FIELD_PERSON_PASSPORT_ISSUE,ATTRIBUTE_VALUE,"Кем выдано не совпадает");


        //10. Нажать продолжить
        clickByXPath(LINK_XPATH_BUTTON_SUBMIT_REGISTRATION_INSURANCE);
        //11. Проверить, что появилось сообщение -Заполнены не все обязательные поля
        checkTrueByXPath(LINK_XPATH_ERROR,"сообщение об ошибке не появилось");

    }


}
