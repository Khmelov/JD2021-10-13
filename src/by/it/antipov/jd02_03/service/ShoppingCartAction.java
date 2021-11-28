package by.it.antipov.jd02_03.service;


import by.it.antipov.jd02_03.model.Good;

public interface ShoppingCartAction {
    void takeCart();
    int putToCart(Good good);
}
