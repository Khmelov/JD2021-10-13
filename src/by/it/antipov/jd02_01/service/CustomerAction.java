package by.it.antipov.jd02_01.service;

import by.it.antipov.jd02_01.model.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
}
