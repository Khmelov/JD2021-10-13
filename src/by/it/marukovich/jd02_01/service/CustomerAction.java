package by.it.marukovich.jd02_01.service;

import by.it.marukovich.jd02_01.model.Good;

public interface CustomerAction {
    void enteredStore();   //вошел в магазин (мгновенно)

    Good chooseGood();     //выбрал товар (от 0,5 до 2 секунд)

    void goOut();          //отправился на выход(мгновенно)
}
