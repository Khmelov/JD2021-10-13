package by.it.antipov.jd02_01.service;

import by.it.antipov.jd02_01.model.Good;

public interface ShoppingCartAction {
    void takeCart();
    int putToCart(Good good);
}
