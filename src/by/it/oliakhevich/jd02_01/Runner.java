package by.it.oliakhevich.jd02_01;

public class Runner {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {     //создали 10 магазинов
            Store application = new Store();
            application.start();

        }
    }
}
