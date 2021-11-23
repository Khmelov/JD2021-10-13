package by.it.malyshchik.jd02_03;

import by.it.malyshchik.jd02_03.model.Manager;
import by.it.malyshchik.jd02_03.model.Store;
import by.it.malyshchik.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Manager manager = new Manager(100);
            Store store = new Store(manager);
            StoreWorker app = new StoreWorker(store);
            app.start();
        }
    }
}
