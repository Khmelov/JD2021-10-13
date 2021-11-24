package by.it.antipov.jd02_02.service;


import by.it.antipov.jd02_02.model.Good;

public interface ShoppingCartAction {
    void takeCart();
    int putToCart(Good good);
}
