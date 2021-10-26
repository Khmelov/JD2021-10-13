package by.it.rudakova.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }

        step1(myArray);
        step2(myArray);
        step3(myArray);
    }

    private static void step3(int[] myArray) {
        int minValue = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            if (minValue > myArray[i]) {
                minValue = myArray[i];
            }
        }
        for (int k = myArray.length - 1; k >= 0; k--) {
            if (myArray[k] == minValue) {
                System.out.print(k + " ");
            }
        }
    }

    private static void step2(int[] myArray) {
        double sum = 0;
        for (int element : myArray) {
            sum += element;
        }

        double average = sum / myArray.length;

        for (int element : myArray) {
            if (element < average) {
                int outputNum = element;
                System.out.println(outputNum);
            }
        }

    }

    private static void step1(int[] myArray) {
        int minValue = myArray[0];
        int maxValue = myArray[0];
        for (int element : myArray) {
            if (element < minValue) {
                minValue = element;
            }
            if (element > maxValue) {
                maxValue = element;
            }
        }
        System.out.println(minValue + " " + maxValue);


    }
}

