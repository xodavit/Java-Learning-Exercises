import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SettingsTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Перед началом");
    }
    @Before
    public void beforeForEach(){
        System.out.println("Перед всеми");
    }
    @Before
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); //не срабатывает в полное окно
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //ждет загрузки страницы
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //ждет загрузки элемента
        wait = new WebDriverWait(driver,20);
    }
    @AfterClass
    public static void afterAll() {
        System.out.println("В конце");
    }
    @After
    public void afterForEach(){
        System.out.println("После всех");
    }
    @After
    public void endDown() {

        driver.quit();
    }
}
