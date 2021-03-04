package sberbank.data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class TestingDataSB  {
    public final static String ATTRIBUTE_VALUE = "value";
    public final static String URL_SB_MAIN_PAGE = "http://www.sberbank.ru/ru/person";

    public final static String LINK_XPATH_MIN_INSURANCE
            = "//div[@class='online-card-program']//h3[contains(text(), 'Минимальная')]";
    //кнопки
    public final static String COOKIE = "//div[@class='cookie-warning cookie-warning_show']//a[@class='cookie-warning__close']";
    public final static String LINK_XPATH_INSURANCE_IN_MAIN_PAGE = "//span[contains(text(), 'Страхование')]";
    public final static String LINK_XPATH_INSURANCE_TRAVEL_IN_MAIN_PAGE
            = "//a[@class='lg-menu__sub-link' and (contains(text(),'Страхование путешественников'))]";
    public final static String LINK_XPATH_BUTTON_REGISTRATION_INSURANCE_ONLINE= "//b[@class='kit-button__text' and (contains(text(), 'Оформить онлайн'))]";
    public final static String LINK_XPATH_BUTTON_REGISTRATION_INSURANCE = "//button[contains(text(), 'Оформить')]";
    public final static String LINK_XPATH_BUTTON_SUBMIT_REGISTRATION_INSURANCE
            = "//button[@class='btn btn-primary page__btn' and @type='submit' and contains(text(),'Продолжить')]";

    //поля для заполнения данных
    public final static String ID_FIELD_PERSON_SURNAME_Z = "surname_vzr_ins_0";
    public final static String ID_FIELD_PERSON_NAME_Z = "name_vzr_ins_0";
    public final static String ID_FIELD_PERSON_BIRTH_DATE_Z= "birthDate_vzr_ins_0";
    public final static String ID_FIELD_PERSON_SURNAME = "person_lastName";
    public final static String ID_FIELD_PERSON_NAME = "person_firstName";
    public final static String ID_FIELD_PERSON_MIDDLE_NAME = "person_middleName";
    public final static String ID_FIELD_PERSON_BIRTH_DATE = "person_birthDate";
    public final static String ID_FIELD_PERSON_PASSPORT_SERIES = "passportSeries";
    public final static String ID_FIELD_PERSON_PASSPORT_NUMBER = "passportNumber";
    public final static String ID_FIELD_PERSON_PASSPORT_DATE = "documentDate";
    public final static String ID_FIELD_PERSON_PASSPORT_ISSUE = "documentIssue";

//    public final static String LINK_XPATH_FIELD_PERSON_SURNAME_Z = "//input[@id='surname_vzr_ins_0']";
//    public final static String LINK_XPATH_FIELD_PERSON_NAME_Z = "//input[@id='name_vzr_ins_0']";
//    public final static String LINK_XPATH_FIELD_PERSON_BIRTH_DATE_Z= "//input[@id='birthDate_vzr_ins_0']";
//    public final static String LINK_XPATH_FIELD_PERSON_SURNAME = "//input[@id='person_lastName']";
//    public final static String LINK_XPATH_FIELD_PERSON_NAME = "//input[@id='person_firstName']";
//    public final static String LINK_XPATH_FIELD_PERSON_MIDDLE_NAME = "//input[@id='person_middleName']";
//    public final static String LINK_XPATH_FIELD_PERSON_BIRTH_DATE = "//input[@id='person_birthDate']";
//    public final static String LINK_XPATH_FIELD_PERSON_PASSPORT_SERIES = "//input[@id='passportSeries']";
//    public final static String LINK_XPATH_FIELD_PERSON_PASSPORT_NUMBER = "//input[@id='passportNumber']";
//    public final static String LINK_XPATH_FIELD_PERSON_PASSPORT_DATE = "//input[@id='documentDate']";
//    public final static String LINK_XPATH_FIELD_PERSON_PASSPORT_ISSUE = "//input[@id='documentIssue']";

    public final static String LINK_XPATH_FIELD_PERSON_SEX_MALE = "//label[contains(text(),'Мужской')]";
    public final static String LINK_XPATH_FIELD_PERSON_SEX_FEMALE = "//label[contains(text(),'Женский')]";

    //ожидаемые поля
    //TODO какая проверка заголовка нужна. заголовок страницы или заголовок на изображении
    public final static String LINK_XPATH_TITLE_TEXT_INSURANCE_TRAVEL
            = "// h2[contains(text(),'Страхование путешественников')]";
    public final static String EXPECTED_TEXT_INSURANCE_TRAVEL = "Страхование путешественников";
        //ошибка
    public final static String LINK_XPATH_ERROR= "//div[@role='alert-form' and @class='alert-form alert-form-error']";
    public final static String EXPECTED_TEXT_ERROR = "При заполнении данных произошла ошибка";

    //TODO Параметризация (заполнять страницу с фио3 раза)
    protected static Stream<Arguments> personData(){
        return Stream.of(
                //surNameZ, nameZ, dateBirthday, lastName, name, middleName, sex, passportSerial, passportNumber, passportDate, passportIssued, mobNumber, email
                //тестовые методы. можно все удалить, актуальные оставить нижние 3. или нижние 3 по 3.
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),

                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),

                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал"),

                Arguments.arguments("Notpupkin","Petr","17.12.1991","Непупкин","Петя","Оганезович","мужской","4511","333333","15.10.2005","Каким-то органом"),
                Arguments.arguments("Sheptunko","Zinka","03.04.1985","Шептуненко","Зинаида","Ореховна","женский","4545","666666","18.07.2015","Кем-то"),
                Arguments.arguments("Big","Fabrio","17.12.1991","Большевичкин","Фабриций","Конфетович","мужской","4705","999999","21.03.2008","Сам нарисовал")
        );
    }
}
