package by.it.karmyzov.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {


        System.out.print("Количество человек: ");

        Scanner scanner = new Scanner(System.in);
        int number_of_person = scanner.nextInt();


        String[] names = new String[number_of_person];
        for (int i = 0; i < number_of_person; i++) {
            System.out.print("Введите фамилию: ");
            names[i] = scanner.next();

        }
        int[][] zp = new int[number_of_person][4];
        for (int i = 0; i < number_of_person; i++) {
            System.out.println("Введите зарплату для" + " " + names[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = scanner.nextInt();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Фамилия      Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("-----------------------------------------------------------");

        double sum_all = 0;
        for (int i = 0; i < number_of_person; i++) {
            System.out.printf("%-13s", names[i] + ":");
            double sum = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", zp[i][j]);
                sum += zp[i][j];
            }
            System.out.printf("%-10.0f", sum);
            System.out.println();

            sum_all += sum;
        }
        System.out.println("-----------------------------------------------------------");

        System.out.printf("%-13s", "Итого");
        System.out.printf("%.0f", sum_all);

        System.out.println();

        double average = (sum_all / (number_of_person * 4));
        System.out.printf("%-13s", "Средняя");
        System.out.printf("%.4f", average);
    }
}