package by.it.rudakova.jd02_01.service;

import by.it.rudakova.jd02_01.model.Goods;

public interface ShoppingCartAction {

        void takeCart(); //взял корзину
        int putToCart(Goods good); //положил товар в корзину(возвращает число товаров)
}
