package ru.dns.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dns.qa.pages.*;

@DisplayName("Тест ДНС")
public class DNSTest extends BaseTest {
    @Test
    @DisplayName("Тест выбора продукта, добавления в корзину и удаления из нее ")
    void test(){

        //1. открыть dns-shop
        VirtualProduct playstation = new VirtualProduct("playstation");
        VirtualProduct detroit = new VirtualProduct("detroit");


        //2. в поиске найти playstation
        new MainPage().searchProduct(playstation);
        //3. кликнуть по playstation 4 slim black
        new ResultsSearchPage().chooseProduct(new ProductName().ps4);
        //4.  запомнить цену
        new ProductPage().addToVirtualBasket();
        //5. Нажать Купить
        new MainPage().addToBasket();
        //6. выполнить поиск Detroit
        new MainPage().searchProduct(detroit);
        //7.  запомнить цену
        new ProductPage().addToVirtualBasket();
        //8. нажать купить
        new MainPage().addToBasket();
        //9. перейти в корзину
        new MainPage().goToBasket();
        //10. TODO проверить цену каждого из товаров и сумму
        VirtualBasket.getAllProductInfoFromVirtualBasket();
        System.out.println("Общая цена в виртуальной корзине = "+VirtualBasket.getTotalPriceFromVirtualBasket());
        //11.  В корзине для playstation Доп.гарантия - выбрать 24 месяца
        new BasketPage().addWarranty();
        //12. TODO дождаться изменения цены и запомнить цену с гарантией

        //13. TODO удалить из корзины Detroit
        new BasketPage().deleteFromBasket();
        //14. TODO проверить что Detroit нет больше в корзине и что сумма уменьшилась на цену Detroit

        //15. TODO добавить еще 2 playstation (кнопкой +) и проверить что сумма верна (равна 3*(цена playstation+гарантия))
        new BasketPage().countAddInBasket();
        new BasketPage().countAddInBasket();
        //16. TODO удалить (кнопка "удалить") Playstation из корзины
        new BasketPage().deleteFromBasket();
        //17. TODO нажать вернуть удаленный товаров

        //18. TODO проверить что 3 playstation снова в корзине и выбрана гарантия 24 месяца

    }
}
