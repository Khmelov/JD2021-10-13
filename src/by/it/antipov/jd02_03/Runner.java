package by.it.antipov.jd02_03;


import by.it.antipov.jd02_03.model.Manager;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Store store = new Store(manager);
        store.start();
    }
}
