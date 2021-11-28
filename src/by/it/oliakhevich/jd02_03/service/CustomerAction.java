package by.it.oliakhevich.jd02_03.service;

import by.it.oliakhevich.jd02_03.model.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
}
