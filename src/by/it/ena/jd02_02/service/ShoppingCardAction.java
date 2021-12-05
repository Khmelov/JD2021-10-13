package by.it.ena.jd02_02.service;

import by.it.ena.jd02_02.model.Good;

public interface ShoppingCardAction {

    void takeCart(); //взял корзину

    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}