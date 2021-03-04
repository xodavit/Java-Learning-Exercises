package ru.appline.qa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


@DisplayName("Автотесты проверяющие что-то")
@Disabled
public class MyJUnit5Test {
    @Tag("first test")
    @Test
    @DisplayName("Мой прекрасный первый тест")
    void test1(){
        System.out.println("Привет, Мир!");
    }
    @Disabled
    @DisplayName("проверка имени")
    @ParameterizedTest(name = "Проверка получения имени {0}")
    @ValueSource(strings = {"Vasya", "Pupkin"})
    void test2(String name){
        System.out.println(name);
    }


    @Disabled
    @DisplayName("проверка имени и фамилии")
    @ParameterizedTest(name = "Проверка получения имени {0}, фамилии {1}, возраста{2}")
    @MethodSource("parametersForTest2")
    void test3(String name, String lastName, int age)
    {
        System.out.print(name+" "+lastName+" "+age);
    }
    static Stream<Arguments> parametersForTest2(){
       return Stream.of(
               Arguments.arguments("petya","nepupkin",17),
               Arguments.arguments("vasya","pupkin",20)
       );
    }
}
