package by.it.oliakhevich.jd02_03.service;

import by.it.oliakhevich.jd02_03.model.Good;

public interface ShoppingCardAction {
    void takeCart();
    int putToCart(Good good);
}
