package logic;

import sweets.Sweet;

public interface Preparation {
    void prepareGift();

    void isPacked();

    void addSweet(Sweet sweet);

    void deleteSweetByIndex(int index);

    void deleteLastSweet();

    int getAllWeight();

    double getAllPrice();

    void getMenu();

    void getInfo();

    void getAllInfo();
}
