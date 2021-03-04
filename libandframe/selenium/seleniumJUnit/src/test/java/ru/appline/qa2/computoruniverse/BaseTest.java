package ru.appline.qa2.computoruniverse;

import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach // вместо Before junit4
    public void startUp(){
        Init.initWebdriver();
    }

//    @AfterEach // вместо After junit4
//    public void afterUp(){
//        Init.getDriver().close();
//    }

}
