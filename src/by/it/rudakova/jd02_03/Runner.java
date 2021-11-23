package by.it.rudakova.jd02_03;

import by.it.rudakova.jd02_03.model.Manager;
import by.it.rudakova.jd02_03.service.Store;

public class Runner {
    public static void main(String[] args) {
        for(int i=0;i<50;i++){
        Manager manager=new Manager(100);
            Store application = new Store(manager);
            application.start();
        }
    }
}
