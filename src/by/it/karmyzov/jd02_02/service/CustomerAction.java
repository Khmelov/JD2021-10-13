package by.it.karmyzov.jd02_02.service;


import by.it.karmyzov.jd02_02.model.Good;

public interface CustomerAction {
    void enteredStore ();

    Good chooseGood ();

    void goQueue ();

    void goOut ();
    }
