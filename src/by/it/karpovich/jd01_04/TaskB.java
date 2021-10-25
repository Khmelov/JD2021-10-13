package by.it.karpovich.jd01_04;

import java.io.PrintStream;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] people = new String[n];
        for (int i = 0; i < people.length - 1; i++) {
            people[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Vvedite ZP: ", people[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.printf("%-5s%-12s%-25s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Итого");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < people.length; i++) {
            System.out.printf("%s: ", people[i]);
            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sum += salary[i][j];
            }
            PrintStream printf = System.out.printf("%-4d\n", sum);
            int total = 0;
            total += sum;
            System.out.printf("Итого     %d\n", total);
            System.out.printf("Средняя    %d\n", (double) total / n / 4.0);
        }



    }
}
