package by.it.karmyzov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);

        double min = Helper.findMin(array);
        System.out.println("min = " + min);

        double max = Helper.findMax(array);
        System.out.println("max = " + max);

        Helper.sort(array);
        InOut.printArray(array);

        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 6},
                {2, 10, 7, 6},
                {3, 8, 2, 6}
        };
        double[] mult1 = Helper.multiply(m, array);
        InOut.printArray(mult1);
    }
}


