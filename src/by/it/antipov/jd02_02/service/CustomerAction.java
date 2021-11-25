package by.it.antipov.jd02_02.service;


import by.it.antipov.jd02_02.model.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
}
