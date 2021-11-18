package by.it.rudakova.jd02_01.service;

import by.it.rudakova.jd02_01.model.Goods;

public interface CustomerAction {
        void enteredStore(); //вошел в магазин (мгновенно)
        Goods chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
        void goOut(); //отправился на выход(мгновенно)
}
