package by.it.karpovich.jd01_04;


import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }

    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == stop) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

}
