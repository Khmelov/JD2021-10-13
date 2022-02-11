package by.it.ena.jd02_01;

import by.it.ena.jd02_01.service.Store;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Store application = new Store();
            application.start();
        }

    }
}