package by.it.shcharbunou.jd02_01.multithreaded_store.services;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.behavior.CustomerAction;

public class CustomerWorker implements Runnable, CustomerAction {

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {

    }

    @Override
    public Good chooseGood() {
        return null;
    }

    @Override
    public void goOut() {

    }
}
