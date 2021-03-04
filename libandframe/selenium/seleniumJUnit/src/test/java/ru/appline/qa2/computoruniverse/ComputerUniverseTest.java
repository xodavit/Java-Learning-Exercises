package ru.appline.qa2.computoruniverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.appline.qa2.computoruniverse.pages.BasketPage;
import ru.appline.qa2.computoruniverse.pages.ProductPage;
import ru.appline.qa2.computoruniverse.pages.ResultsPage;
import ru.appline.qa2.computoruniverse.pages.SearchBar;

public class ComputerUniverseTest extends BaseTest {
    @Test
    public void firstPageObjectTest() {

        new SearchBar().search("Macbook");
        ResultsPage resultsPage = new ResultsPage();
        resultsPage.chooseByPartialNameFast("Apple MacBook Pro 13.3 MV962D/A");
        ProductPage productPage = new ProductPage();
        productPage.addToBaksetAndSaveToVirtualBasket();
        productPage.goToBasket();
        BasketPage basketPage = new BasketPage();
        Assertions.assertEquals(
                getTotalPriceFromVirtualBasket(),
                basketPage.getFactualPrice(),"Цена в корзине не соотвествует ожидаемой!");
    }


    private Double getTotalPriceFromVirtualBasket() {
        return VirtualBasket.getPrices().values().stream().reduce((x, y) -> x + y)
                .get();
    }
}
