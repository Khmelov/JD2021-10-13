package by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.behavior;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
}
