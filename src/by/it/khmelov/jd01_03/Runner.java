package by.it.khmelov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //String line = "12.1 34 56 7 8 9 11 12 -0.12456 8.9";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 5);
    }
}
