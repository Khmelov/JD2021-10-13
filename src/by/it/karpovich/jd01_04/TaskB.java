package by.it.karpovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите кол-во работников:");
        Scanner console = new Scanner(System.in);
        int workersCount = console.nextInt();
        String[] workers = new String[workersCount];
        System.out.println("Введите имена работников");
        for (int i = 0; i < workers.length; i++) {
            workers[i] = console.next();
        }

        int[][] money = new int[workersCount][4];
        for (int i = 0; i < money.length; i++) {
            System.out.println("Введите зарплату [Квартал1-4 через пробел] для: " + workers[i]);
            for (int j = 0; j < 4; j++) {
                money[i][j] = console.nextInt();
            }
        }
        int[] yearSalary = new int[workersCount];
        int totalYearMoney = 0;
        double averageSalary;
        System.out.println("---------------------------------------------------------");
        System.out.println("  Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого ");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < workersCount; i++) {
            System.out.printf("%10s: ", workers[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", money[i][j]);
                yearSalary[i] += money[i][j];
                totalYearMoney += money[i][j];
            }
            System.out.printf("%-5d\n", yearSalary[i]);
        }
        averageSalary = (double) totalYearMoney / (workersCount * 4);
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-12s%-10d\n", "Итого", totalYearMoney);
        System.out.printf("%-12s%-10.4f", "Средняя", averageSalary);
    }
}