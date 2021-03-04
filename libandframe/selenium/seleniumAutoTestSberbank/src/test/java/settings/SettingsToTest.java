package settings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SettingsToTest {

    protected final static String PATH_TO_CHROME_DRIVER = "drivers/chromedriver.exe";
    protected final static String WEB_CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private static WebDriver DRIVER;
    private static WebDriverWait WAIT;




    public static WebDriver getDRIVER(){
        return DRIVER;
    }
    public static WebDriverWait getWAIT(){
        return WAIT;
    }

    @BeforeEach
    void initialDriver(){
        //TODO •Выбор браузера (IE, Chrome, FireFox) через переменную
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        System.setProperty(WEB_CHROME_DRIVER_NAME, PATH_TO_CHROME_DRIVER);
        DRIVER = new ChromeDriver();
        System.out.println("Экзмепляр драйвера создан");
        WAIT = new WebDriverWait(DRIVER,20);
        System.out.println("Тайм-аут драйвера установлен в 20 секунд");
        DRIVER.manage().window().maximize();
        System.out.println("Работа в окне на весь экран");
        DRIVER.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Тайм-аут прогрузки страницы установлен 20 секунд");

    }
    @AfterEach
    void quitDriver(){
        System.out.println("Конец теста");
        try {
            System.out.println("Задержка перед выходом 5 секунд");
            Thread.sleep(15000); // не стоит тормозить потоки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DRIVER.quit();
        System.out.println("Выход из драйвера");
    }
}
