import org.junit.*;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class MyFirstTest {

    @Test(expected =  AssertionError.class)
    public void myFirstTest(){
        boolean isParamActiv = false;
        System.out.println("Тест 1");
        if (!isParamActiv) {
            Assert.fail("не удалось получить значение из бд");
        }
        System.out.println("Тест 2");

    }

    @Test(timeout = 2000)
    public void timeOutTest() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Test
    public void mySecondTest(){
        System.out.println("Тест 2");
        String browser = System.getProperty("browser","IE");
        Assert.assertEquals("Выбранный браузер не соответствует","IE",browser);
    }
    @Test
    public void  calcAdditionTest(){
        System.out.println("Тест 3");
        Calculator calc = new Calculator();
        int x = 3;
        int y = 2;
        int result = calc.sum(x,y);
//        if (result!=6) {
//            throw new RuntimeException("проблема с подсчетом");
//        }

        Assert.assertEquals(String.format("Результат вычислений операции sum(%d, %d) не совпадает", x, y),5,result);
        Assert.assertEquals(5,5); //bad idea
        Assert.assertEquals("результат вычислений не совпадает",5,result);
        Assert.assertTrue("результат вычислений не совпадает",5==result); // bad idea
        Assert.assertThat(result,is(5));//bad idea
        Assert.assertThat("тестовая строка",containsString("строка")); // bad idea
        Assert.assertTrue("тестовая строка".contains("строка2"));// bad idea


    }

}
