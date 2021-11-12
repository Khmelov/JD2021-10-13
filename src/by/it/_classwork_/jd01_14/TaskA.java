package by.it._classwork_.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        String stringPath = PathFinder.getStringPath(TaskA.class, "dataTaskA.bin");
        String txtPath = PathFinder.getStringPath(TaskA.class, "resultTaskA.txt");
        saveRandomIntegers(stringPath, 20, 1000);
        List<Integer> list = getListFromFile(stringPath);
        printToConsole(list);
        printToTextFile(list, txtPath);
    }

    private static List<Integer> getListFromFile(String stringPath) {
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
        return list;
    }

    @SuppressWarnings("SameParameterValue")
    private static void saveRandomIntegers(String stringPath, int size, int bound) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(stringPath)
                        )
                )
        ) {
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                int value = random.nextInt(bound);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<Integer> list) {
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
        }
        double average = getAverage(list);
        System.out.printf("%navg=%f%n", average);
    }

    private static void printToTextFile(List<Integer> list, String fileTxt) {
        try (PrintWriter out = new PrintWriter(fileTxt)) {
            for (Integer integer : list) {
                out.printf("%d ", integer);
            }
            double average = getAverage(list);
            out.printf("%navg=%f%n", average);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static double getAverage(List<Integer> list) {
        double avg = 0;
        for (Integer integer : list) {
            avg += integer;
        }
        avg /= list.size();
        return avg;
    }


}
