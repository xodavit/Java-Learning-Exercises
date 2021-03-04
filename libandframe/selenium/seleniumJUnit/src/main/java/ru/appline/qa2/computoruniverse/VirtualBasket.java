package ru.appline.qa2.computoruniverse;

import java.util.HashMap;
import java.util.Map;

public class VirtualBasket {
    static Map<String, Double> prices =new HashMap<>();

    public static void addToBasket(String name, Double price){
        prices.put(name, price);
    }

    public static Map<String, Double> getPrices() {
        return prices;
    }
}
