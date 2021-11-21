package by.it.rudakova.jd02_02.service;

import by.it.rudakova.jd02_02.model.Goods;

public interface CustomerAction {
        void enteredStore(); //вошел в магазин (мгновенно)
        Goods chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
        void goQueue();
        void goOut(); //отправился на выход(мгновенно)
}
