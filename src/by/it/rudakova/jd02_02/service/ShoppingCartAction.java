package by.it.rudakova.jd02_02.service;

import by.it.rudakova.jd02_02.model.Goods;

public interface ShoppingCartAction {

        void takeCart(); //взял корзину
        int putToCart(Goods good); //положил товар в корзину(возвращает число товаров)
}
