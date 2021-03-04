package settings;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final static String URL_RGS = "http://www.rgs.ru";
    protected final static String PATH_TO_DRIVER = "drivers/chromedriver.exe";
    protected final static String WEB_CHROME_DRIVER_NAME = "webdriver.chrome.driver";

    @Before
    public void startUp() {
        System.setProperty(WEB_CHROME_DRIVER_NAME, PATH_TO_DRIVER);
        driver = new ChromeDriver();
        System.out.println("Экзмепляр драйвера создан");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.printf("Страница сайта %s прогружена\n",URL_RGS);
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void endDown(){
        System.out.println("Конец теста");
//        try {
//            System.out.println("Задержка перед выходом 5 секунд");
//            //Thread.sleep(5000); // не стоит тормозить потоки
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.quit();
        System.out.println("Выход из драйвера");
    }


}
