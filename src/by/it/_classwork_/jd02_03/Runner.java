package by.it._classwork_.jd02_03;

import by.it._classwork_.jd02_03.model.Manager;
import by.it._classwork_.jd02_03.model.Store;
import by.it._classwork_.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Manager manager = new Manager(100);
            Store store = new Store(manager);
            StoreWorker app = new StoreWorker(store);
            app.start();
        }
    }
}
