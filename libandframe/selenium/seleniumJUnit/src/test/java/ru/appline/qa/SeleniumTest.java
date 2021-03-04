package ru.appline.qa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
@Disabled
public class SeleniumTest extends BaseSeleniumTest {
    String someXpath = "";
    @Test
    @Disabled
    void someTest(){
        goToUrl("");
        clickField(someXpath);
        findFieldAndClick(someXpath);
        String actualText = getFieldText(someXpath);
    }
}
