package by.it.shcharbunou.jd02_03.multithreaded_store.application;

import by.it.shcharbunou.jd02_03.multithreaded_store.services.store_services.Store;

public class Runner {

    public static void main(String[] args) {
        Thread application = new Thread(new Store());
        application.start();
    }
}
