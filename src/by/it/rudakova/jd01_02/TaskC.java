package by.it.rudakova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы:");
        Scanner scanner = new Scanner(System.in);
        int inPutNumber = scanner.nextInt();
        int[][] myArray = step1(inPutNumber);

        step2(myArray);

        step3(myArray);
    }

    public static int[][] step1(int sizeMatrix) {
        boolean foundFirstNumber = false;
        boolean foundSecondNumber = false;
        int valueFirst = sizeMatrix;
        int valueSecond = -sizeMatrix;
        int[][] myArray = new int[sizeMatrix][sizeMatrix];
        do {
            for (int i = 0; i < sizeMatrix; i++) {
                for (int k = 0; k < sizeMatrix; k++) {
                    Random random = new Random();
                    int randomNumber = -sizeMatrix + random.nextInt(sizeMatrix * 2 + 1);
                    myArray[i][k] = randomNumber;
                }
            }
            foundFirstNumber = false;
            foundSecondNumber = false;
            for (int i = 0; i < myArray.length; i++) {
                for (int k = 0; k < myArray.length; k++) {
                    if (myArray[i][k] == valueFirst) {
                        foundFirstNumber = true;
                        continue;
                    } else if (myArray[i][k] == valueSecond) {
                        foundSecondNumber = true;
                        continue;
                    }
                }
            }
        }
        while (foundFirstNumber == false || foundSecondNumber == false);

        for (int i = 0; i < myArray.length; i++) {
            for (int k = 0; k < myArray.length; k++) {
                System.out.print(myArray[i][k] + " ");
            }
            System.out.println();
        }


        return myArray;
    }

    public static int step2(int[][] arr) {
        boolean flag = false;
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[i][k] > 0) {
                    counter++;
                    if (counter == 2)
                        break;
                    flag = true;
                    continue;
                }
                if (flag == true) {
                    sum = sum + arr[i][k];
                }

            }
            counter = 0;
            flag = false;
        }
        System.out.println("Сумма равна: " + sum);
        return sum;
    }

    public static int[][] step3(int[][] arr) {

        int maxValue = getMaxValue(arr);

        boolean[] rows = new boolean[arr.length];
        boolean[] columns = new boolean[arr[0].length];

        int rowsToDelete = 0;
        int columnsToDelete = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[i][k] == maxValue) {
                    if (rows[i] == false) {
                        rows[i] = true;
                        rowsToDelete++;
                    }
                    if (columns[k] == false) {
                        columns[k] = true;
                        columnsToDelete++;
                    }
                }

            }
        }

        int[][] resultArray = new int[arr.length - rowsToDelete][arr[0].length - columnsToDelete];

        int resultRow = 0;
        int resultColumn = 0;

        for (int i = 0; i < arr.length; i++) {
            if (rows[i]) {
                continue;
            }
            resultColumn = 0;

            for (int k = 0; k < arr[0].length; k++) {
                if (columns[k]) {
                    continue;
                }
                resultArray[resultRow][resultColumn] = arr[i][k];
                resultColumn++;
            }
            resultRow++;

        }
        return resultArray;
    }

    private static int getMaxValue(int[][] arr) {
        int maxValue = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                if (maxValue < arr[i][k]) {
                    maxValue = arr[i][k];
                }
            }
        }
        return maxValue;
    }
}









