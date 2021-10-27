package by.it.malyshchik.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников:");
        int personAmount = sc.nextInt();
        String[] personSurname = new String[personAmount];
        System.out.println("Введите фамилии сотрудников:");
        for (int i = 0; i < personAmount; i++) {
            personSurname[i] = sc.next();
        }
        int[][] personSalary = new int[personAmount][4];
        for (int i = 0; i <personSalary.length; i++) {
            System.out.println("Введите зарплату для " + personSurname[i]);
            for (int j = 0; j < 4; j++) {
                personSalary[i][j] = sc.nextInt();
//    Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
//    итогом за год в последней колонке.
//    B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую
//    квартальную зарплату с точностью как минимум до 4-го знака .
            }
        }
        String line = "_".repeat(54);
        System.out.println(line);
        System.out.println("Фамилия  Квартал1   Квартал2   Квартал3   Квартал4   Итого");
        System.out.println(line);

        int total = 0;
        for (int i = 0; i < personSurname.length; i++) {
            System.out.printf("%s: ", personSurname[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", personSalary[i][j]);
                sum += personSalary[i][j];
            }
            System.out.printf("%-4d\n", sum);
            total +=sum;
        }
        System.out.printf("Итого     %d\n",total);
        System.out.printf("Средняя   %7.4f\n", (double)total/personAmount/4.0);
    }


}