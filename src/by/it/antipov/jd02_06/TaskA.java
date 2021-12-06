package by.it.antipov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder root = getRoot();
        System.out.println(root);
      File dataTaskA = new File(String.valueOf(root));
        Logger logger = Logger.getLogger();
            for (int i = 0; i < 4; i++) {
                Thread thread = new Thread(logger);
                thread.start();
            }
    }

    public static StringBuilder getRoot() {
        StringBuilder root = new StringBuilder(System.getProperty("user.dir"));
        String partTwo = TaskA.class.getName().replace(".", File.separator).replace("TaskA","");
        root.append(File.separator+"src"+File.separator+partTwo+"log.txt");
        return root;
    }
}
