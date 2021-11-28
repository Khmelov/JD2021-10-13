package by.it.malyshchik.jd02_02;

import by.it.malyshchik.jd02_02.model.Manager;

public class Runner {
    public static void main(String[] args) {
       // for (int i = 0; i < 50; i++) {
            Manager manager = new Manager(100);
            Store application = new Store(manager);
            application.start();
       // }
    }
}
