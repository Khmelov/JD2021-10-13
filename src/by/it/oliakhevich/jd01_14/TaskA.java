package by.it.oliakhevich.jd01_14;


import java.io.*;

public class TaskA {

    private static String dir(Class<?> class1) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = class1.getName().replace(class1.getSimpleName(), "").replace(".", File.separator);
        return path = classDir;
        //File.separator - встроенный сепаратор, чтобы слеши были оптимизированны под все системы
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
            PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))){
            double sum = 0;
            double count = 0;
            while (input.available() > 0) {
                int i = input.readInt();
                System.out.println(i+" ");
                out2.print((i+" "));
                sum = sum + i;
                count++;
            }
            System.out.println("\navg = " + sum / count);
            out2.print(("\navg = " + sum / count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
