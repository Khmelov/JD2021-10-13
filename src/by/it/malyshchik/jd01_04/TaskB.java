package by.it.malyshchik.jd01_04;

import java.util.Scanner;

public class TaskB {
    //    Введите с консоли число людей n (nextInt() в сканере).
//             Затем введите одномерный массив их фамилий (next() в сканере).
//             Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
//             Зарплаты имеют тип int.
//             Нужно для каждой фамилии выводить подсказку
// После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
//    сканере).
//
//             Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
//    итогом за год в последней колонке.
//    B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую
//    квартальную зарплату с точностью как минимум до 4-го знака .
//    private static int sumStrArray(int sum) {
//        double[][] salaries = new double[0][];
//        for (int i = 0; i < salaries.length; i++) {
//            for (int j = 0; j < salaries[i].length; j++) {
//                sum += salaries[i][j];
//
//            }
//        }
//        return sum;
//    }
    private static void printSumElemRowsArray(int[][] arr) {
        int summ = 0;
        for (int[] row : arr) {
            for (int elem : row) {
                summ += elem;
                System.out.printf("%3d,", elem);
            }
            System.out.println(" | = " + summ);
            summ = 0;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество людей: ");
        int personAmount = sc.nextInt();

        String[] surnames = new String[personAmount];
        System.out.println("Введите фамилии:");
        for (int i = 0; i < personAmount; i++) {
            surnames[i] = sc.next();
        }
        int[][] salaries = new int[personAmount][4];
        for (int i = 0; i < personAmount; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = sc.nextInt();
            }
        }
//        int[][] matrix = feelMatrix();
//        printMatrix(matrix);

        for (int i = 0; i < salaries.length; i++) {
            int sum = 0;
            for (int j = 0; j < salaries[i].length; j++) {
                sum += salaries[i][j];

            }
            System.out.println(sum);


//            double sumStrAvg = sum * 1.0 / 4;
//            System.out.println(sumStrAvg);
//            double sumAvg = sumStrAvg / 3;
//            System.out.println(sumAvg);

//        System.out.println("В " + i + "-й строке " + salaries[i].length + " элементов, их сумма = " + sum);
        }
        int sumA = 0;
        for (int i = 0; i < salaries.length; i++) {
            for (int j = 0; j < salaries[i].length; j++) {
                sumA += salaries[i][j];
            }

        }
        System.out.println("SummaA= " + sumA);

        printSumElemRowsArray(salaries);

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-----------------------------------------------------");
//       int col=0;

        for (int i = 0; i < salaries.length; i++) {
            int j;
            for (j = 0; j < salaries[i].length; j++) {

            }

//            +":"+"[% -2d]", i, salaries[i][j]
//            + "%4d", i, j, salaries[i][j]


            System.out.println(surnames[i]);

        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Итого" + " " + sumA);
//    System.out.println("Средняя" + " "+ sumAvg);

        }

//    private static void sumStrArray(int i) {
//        double[][] salaries = new double[0][];
//        int sum = 0;
//        for (i = 0; i < salaries.length; i++) {
//            for (int j = 0; j < salaries[i].length; j++) {
//                sum += salaries[i][j];
//                System.out.println(sum);
//            }
//        }
//
//    }
    }




