package by.it.oliakhevich.jd02_02;

import by.it.oliakhevich.jd02_02.Store;
import by.it.oliakhevich.jd02_02.model.Manager;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Store store = new Store(manager);
        store.start();

    }
}
