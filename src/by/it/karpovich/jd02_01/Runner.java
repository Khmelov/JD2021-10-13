package by.it.karpovich.jd02_01;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Store application = new Store();
            application.start();
        }

    }
}
