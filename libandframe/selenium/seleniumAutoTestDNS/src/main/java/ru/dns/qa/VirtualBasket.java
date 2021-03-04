package ru.dns.qa;

import java.util.ArrayList;
import java.util.List;


public class VirtualBasket {
    private static List<VirtualProduct> virtualBasket = new ArrayList<>();

    public static void addToBasket(VirtualProduct virtualProduct){
        virtualBasket.add(virtualProduct);
    }

    public static void deleteFromBasket(VirtualProduct virtualProduct){

        virtualBasket.remove(virtualProduct);
    }
    public static void changeProductInVirtualBasket(VirtualProduct virtualProduct){

    }
    public static void getAllProductInfoFromVirtualBasket(){
        System.out.println("Товаров в виртуальной корзине = "+virtualBasket.size());
        for ( VirtualProduct vp: virtualBasket
             ) {
            System.out.println(vp.toString());
        }
    }

    //TODO получение продукта,  изменение цены, гарантии. получение общей цены

    public static int getTotalPriceFromVirtualBasket() {
        int totalPrice = 0;
        for ( VirtualProduct vp: virtualBasket
        ) {
            totalPrice+=vp.getPrice();
        }
        return totalPrice;
    }


}
