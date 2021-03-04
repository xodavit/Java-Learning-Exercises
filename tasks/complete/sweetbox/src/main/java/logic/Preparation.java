package logic;

import sweets.Sweetnees;

public interface Preparation {
    void prepareGift();
    void isPacked();
    void addSweet(Sweetnees sweetnees);
    void deleteSweetByIndex(int index);
    void deleteLastSweet();
    int getAllWeight();
    double getAllPrice();
    void getMenu();
    void getInfo();
    void getAllInfo();
}
