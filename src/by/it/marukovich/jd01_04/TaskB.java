package by.it.marukovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите количество людей (n)");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] people = new String[n];
        int sumAllPayments = 0;
        double quarterlySum = 0;
        for (int i = 0; i < n; i++) {
            people[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        int[] summary = new int[4];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату для %s\n", people[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;;

            for (int j = 0; j < salary[0].length; j++) {
                sum += salary[i][j];
            }
            summary[i] = sum;

            System.out.printf("%7s: %-8d  %-8d  %-8d  %-8d  %-5d\n", people[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], summary[i]);
        }
        for (int i = 0; i < summary.length; i++) {
            sumAllPayments+=summary[i];
        }
        System.out.printf("Итого:   %d\n", sumAllPayments);
        quarterlySum = ((double) sumAllPayments / n /4);
        System.out.printf("Средняя:   %.4f", quarterlySum);
    }
}
