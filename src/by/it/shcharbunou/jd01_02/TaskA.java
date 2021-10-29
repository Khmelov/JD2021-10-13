package by.it.shcharbunou.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[10];
        boolean isCorrect;
        System.out.println("Fill the array:");
        for (int i = 0; i < arr.length; i++) {
            do {
                isCorrect = true;
                System.out.println("Input the " + (i + 1) + " element:");
                try {
                    arr[i] = Integer.parseInt(input.next());
                } catch (Exception e) {
                    System.out.println("Error: Value must be integer. Try again.");
                    isCorrect = false;
                }
            } while (!isCorrect);
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int element : arr) {
            minNum = Math.min(minNum, element);
            maxNum = Math.max(maxNum, element);
        }
        System.out.println(minNum + " " + maxNum);
    }

    private static void step2(int[] arr) {
        double elementsAmount = 0;
        for (int element : arr) {
            elementsAmount += element;
        }
        double average = elementsAmount / arr.length;
        for (int element : arr) {
            if (element < average) {
                System.out.print(element + " ");
            }
        }
        System.out.print("\n");
    }

    private static void step3(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        for (int element : arr) {
            minNum = Math.min(minNum, element);
        }
        for (int i = arr.length - 1; i > -1; i--) {
            if (minNum == arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
