package by.it.oliakhevich.jd01_04;


import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        System.out.println("Введите количество работников");
        double sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        int[][] salari = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите фамилию работников");
            name[i] = sc.next();

        }
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < 4; j++) {
                salari[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-6s%n", "Фамилия", "квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s", name[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", salari[i][j]);
                sum = sum + salari[i][j];
            }
            System.out.printf("%-10s", sum);
            sum = 0;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sum = sum + salari[i][j];
            }

        }
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-9s%-10s%n", "Итого", sum);
        System.out.printf("%-9s%-10s\n", "Средняя ", sum / n / 4);
    }

}





