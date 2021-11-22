package by.it.karmyzov.jd02_03.service;


import by.it.karmyzov.jd02_03.model.Good;

public interface CustomerAction {
    void enteredStore ();

    Good chooseGood ();

    void goQueue ();

    void goOut ();
    }
