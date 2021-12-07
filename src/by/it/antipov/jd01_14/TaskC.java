package by.it.antipov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class TaskC {
    public static void main(String[] args) {
                StringBuilder root = new StringBuilder(System.getProperty("user.dir"));
        StringBuilder root2 = new StringBuilder(System.getProperty("user.dir"));
        String partTwo = TaskC.class.getName()
                .replace(".", File.separator)
                .replace("TaskC", "")
                .replace("\\jd01_14\\", "");
        String partTwo2 = TaskC.class.getName()
                .replace(".", File.separator)
                .replace("TaskC", "resultTaskC.txt");
              root2.append(File.separator + "src" + File.separator +partTwo2);
        root.append(File.separator + "src" + File.separator + partTwo);
        try (FileWriter fileWriter = new FileWriter(String.valueOf(root2),true)){
            File antipov = new File(String.valueOf(root));
            File[] lessons = antipov.listFiles();
            for (File lesson:lessons) {
                File[] classes = lesson.listFiles();
                for (File clazz:classes) {
                    String format1 = String.format("file:%s  dir:%s \n", clazz.getName(), lesson.getName());
                   if  (Objects.nonNull(clazz.listFiles())){
                       for (File subClazz: Objects.requireNonNull(clazz.listFiles())) {
                           String format2 = String.format("file:%s  dir:%s \n", subClazz.getName(), clazz.getName());
                           System.out.printf(format2);
                           fileWriter.write(format2);
                       }
                   }
                    System.out.printf(format1);
                    fileWriter.write(format1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(root);


    }
}
