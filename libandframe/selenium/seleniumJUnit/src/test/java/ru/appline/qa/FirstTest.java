package ru.appline.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
@Disabled
public class FirstTest {
    //JUnit5 больше не требует, чтоб методы были публичными
    @Test
    void test(){
        Assertions.assertTrue("It "+"works!" == "It works!");
    }
    //Опциональное сообщение сделали последним аргументом
    @Test
    void test2(){
        int expected = 1;
        int actual = expected;
        Assertions.assertEquals(expected,actual,"Значения не равны");
    }
    //добавили спец. метод для логической группиовки тестов
    // но я не смог его написать так, чтоб он заработал :D
    // в группе все ассерты исполняются независимо,
    // успех - когда прошли успешно все ассерты
//    @Test
//    void test3(){
//        Assertions.assertAll("habr",
//                () -> assertThat("https://habrahabr.ru", startsWith("https")),
//                () -> assertThat("https://habrahabr.ru", endsWith(".ru"))
//        );
//    }


    // метод для сравнения набора строк. Поддерживаются регулярные выражения!
    //в моих руках не заработл :D
//    @Test
//    void  test4(){
//        Assertions.assertLinesMatch(
//                asList("можно сравнивать строки", "а можно по regex: \\d{2}\\.\\d{2}\\.\\d{4}"),
//                asList("можно сравнивать строки", "а можно по regex: 12.09.2017")
//        );
//    }

    @Test
    void test5(){
        Assertions.assertTrue("habr" == "habr", () -> "Assertion messages can be lazily evaluated");
    }
    //Работа с исключениями стала более линейной.
    //но не для меня xD
    @Test
    void testException(){
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("что-то пошло не так");
        });

        Assertions.assertEquals("что-то пошло не так", exception.getMessage());
    }

    //Параметризированные тесты позволяют запускать тест несколько раз с различными входными данными.
    // На данный момент поддерживаются только данные примитивных типов: int, long, double, String.
    //JUnit 5 определяет несколько дополнительных аннотаций для указания источника данных для параметризированных тестов.
    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithStringParameter(String argument) {
        Assertions.assertNotNull(argument);
    }
    @ParameterizedTest
    @ValueSource(strings = { "01.01.2017", "31.12.2017" })
    void testWithConverter(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate date) {
        Assertions.assertEquals(2017, date.getYear());
    }

    //Пример с разбором CSV.
    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
        // или даже так: @CsvFileSource(resources = "/two-column.csv")
    void testWithCsvSource(String first, int second) {
        Assertions.assertNotNull(first);
        Assertions.assertNotEquals(0, second);
    }

    //Пример с Enum.
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        Assertions.assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }

    @RepeatedTest(5)
    void repeatedTest() {
        System.out.println("Этот тест будет запущен пять раз. ");
    }
    // Новая аннотация для улучшения читаемости при выводе результатов тестов.
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {}

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

    @Test
    void failingTest() {
        Assertions.fail("a failing test");
    }

    // вместо @BeforeClass
    @BeforeAll
    static void initAll() {
    }

    // вместо @Before
    @BeforeEach
    void init() {
    }

    // вместо @After
    @AfterEach
    void tearDown() {
    }

    // вместо @AfterClass
    @AfterAll
    static void tearDownAll() {
    }
}
