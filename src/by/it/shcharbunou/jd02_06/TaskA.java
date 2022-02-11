package by.it.shcharbunou.jd02_06;

public class TaskA {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Logger instance = Logger.getInstance();
                instance.log("smthng");
            }).start();
        }
    }
}
