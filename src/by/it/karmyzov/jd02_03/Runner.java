package by.it.karmyzov.jd02_03;


import by.it.karmyzov.jd02_03.model.Manager;
import by.it.karmyzov.jd02_03.service.Store;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
            Store aplication = new Store(manager);
            aplication.start();
        }
    }

