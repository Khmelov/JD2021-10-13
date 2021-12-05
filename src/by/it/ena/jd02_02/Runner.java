package by.it.ena.jd02_02;

import by.it.ena.jd02_02.model.Manager;
import by.it.ena.jd02_02.service.Store;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Store application = new Store(manager);
        application.start();

    }
}