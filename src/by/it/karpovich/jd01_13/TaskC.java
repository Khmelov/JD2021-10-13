package by.it.karpovich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        readData();
    }

    private static void readData() throws NumberFormatException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Double> valuesList = new ArrayList<>();
        int exceptionsCounter = 0;
        for (; ; ) {
            try {
                valuesList.add(Double.parseDouble(scanner.next()));
            } catch (NumberFormatException e) {
                if (exceptionsCounter == 5) {
                    break;
                }
                Thread.sleep(100);
                for (int i = valuesList.size() - 1; i > -1; i--) {
                    System.out.print(valuesList.get(i) + " ");
                }
                System.out.println();
                exceptionsCounter++;
            }
        }
    }
}
