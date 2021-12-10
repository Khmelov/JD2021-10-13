package by.it.oliakhevich.jd02_02.service;

import by.it.oliakhevich.jd02_02.model.Good;

public interface ShoppingCardAction {
    void takeCart();
    int putToCart(Good good);
}
