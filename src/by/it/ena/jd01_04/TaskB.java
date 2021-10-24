package by.it.ena.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] peoples = new String[n];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + peoples[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        String line = "-".repeat(54);
        System.out.println(line);
        System.out.println(" Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println(line);
        int total = 0;
        for (int i = 0; i < peoples.length; i++) {
            System.out.printf("%8s: ", peoples[i]);
            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sum += salary[i][j];
            }
            System.out.printf("%-4d\n", sum);
            total += sum;
        }
        System.out.println(line);
        System.out.printf("Итого   %d\n", total);
        System.out.printf("Средняя %f\n", (double) total / n / 4.0);

    }
}
