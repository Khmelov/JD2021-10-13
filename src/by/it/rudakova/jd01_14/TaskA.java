package by.it.rudakova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        String stringPath = PathFinder.getStringPath(TaskA.class, "dataTaskA.bin");
        String textPath = PathFinder.getStringPath(TaskA.class, "resultTaskA.txt");
        Random random = new Random();
        try (FileOutputStream fileOutputStream = new FileOutputStream(stringPath);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {
            for (int i = 0; i < 20; i++) {
                int value = random.nextInt(1000);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> list = new ArrayList<>();
        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(stringPath)));
            while (dataInputStream.available() > 0) {

                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(dataInputStream)) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try (PrintWriter printWriter = new PrintWriter(textPath)) {

            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            System.out.println();

            double avg = 0;
            for (Integer integer : list) {
                avg += integer;
            }
            avg = avg / list.size();
            System.out.printf("%navg=%f%n", avg);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
