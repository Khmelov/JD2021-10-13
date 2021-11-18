package by.it.shcharbunou.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();
        outputRandomNumbers(pathFinder);
        List<Integer> randomNumbers = new ArrayList<>();
        readNumbers(randomNumbers, pathFinder);
        printRandomNumbers(randomNumbers);
        double average = findRandomNumbersAverage(randomNumbers);
        printRandomNumbersAverage(average);
        outputResultInFile(randomNumbers, average, pathFinder);
    }

    private static void outputResultInFile(List<Integer> randomNumbers, double average, PathFinder pathFinder) {
        String stringPath = pathFinder.getStringPath(TaskA.class, "resultTaskA.txt");
        try (PrintWriter printWriter = new PrintWriter(stringPath)) {
            printRandomNumbersToFile(randomNumbers, printWriter);
            printRandomNumbersAverageToFile(average, printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printRandomNumbersAverageToFile(double average, PrintWriter printWriter) {
        printWriter.printf("avg=%s", average);
    }

    private static void printRandomNumbersToFile(List<Integer> randomNumbers, PrintWriter printWriter) {
        for (Integer randomNumber : randomNumbers) {
            printWriter.printf("%d ", randomNumber);
        }
        printWriter.println();
    }

    private static void printRandomNumbersAverage(double average) {
        System.out.printf("avg=%s", average);
    }

    private static double findRandomNumbersAverage(List<Integer> randomNumbers) {
        double amount = 0;
        for (Integer randomNumber : randomNumbers) {
            amount += randomNumber;
        }
        return amount / randomNumbers.size();
    }

    private static void printRandomNumbers(List<Integer> randomNumbers) {
        for (Integer randomNumber : randomNumbers) {
            System.out.printf("%d ", randomNumber);
        }
        System.out.println();
    }

    private static void readNumbers(List<Integer> randomNumbers, PathFinder pathFinder) {
        String stringPath = pathFinder.getStringPath(TaskA.class, "dataTaskA.bin");
        try (DataInputStream dataInputStream =
                new DataInputStream(new BufferedInputStream
                        (new FileInputStream(stringPath)))) {
            while (dataInputStream.available() > 0) {
                randomNumbers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputRandomNumbers(PathFinder pathFinder) {
        Random random = new Random();
        String stringPath = pathFinder.getStringPath(TaskA.class, "dataTaskA.bin");
        int temporaryRandomValue;
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new BufferedOutputStream
                             (new FileOutputStream(stringPath)))) {
            for (int i = 0; i < 20; i++) {
                temporaryRandomValue = random.nextInt();
                dataOutputStream.writeInt(temporaryRandomValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
