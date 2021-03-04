package ru.dns.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void startUp(){
        InitialWebDriver.initialWebDriver();
        System.out.println("Инициализация драйвера");
    }
    @AfterEach
    void endDown(){
        //InitialWebDriver.closeDriver();
        System.out.println("Конец теста");
    }
}
