package by.it.rudakova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число людей:");
        Scanner scanner = new Scanner(System.in);
        int quantityPersons = scanner.nextInt();
        System.out.println("Введите фамилии людей:");
        String[] personSurname = new String[quantityPersons];
        for (int i = 0; i < personSurname.length; i++) {
            personSurname[i] = scanner.next();
        }
        int quarterNumber = 4;
        int[][] salaryArray = new int[quantityPersons][quarterNumber];
        for (int i = 0; i < personSurname.length; i++) {
            System.out.println("Введите запрлату для " + personSurname[i]);
            for (int k = 0; k < quarterNumber; k++) {
                salaryArray[i][k] = scanner.nextInt();
            }
        }


        System.out.println("------------------------------------------------------------");

        String[] tableHead = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        for (String element : tableHead) {
            System.out.printf("%-10s ", element);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------");

        int personTotalSalary = 0;
        int total = 0;

        for (int i = 0; i < personSurname.length; i++) {
            personTotalSalary = 0;
            System.out.printf("%7s:   ", personSurname[i]);
            for (int k = 0; k < salaryArray[i].length; k++) {
                System.out.printf("%-11d", salaryArray[i][k]);
                personTotalSalary = personTotalSalary + salaryArray[i][k];
            }
            System.out.println(personTotalSalary);
            total = total + personTotalSalary;

            System.out.println();
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-5d ", "Итого", total);
        int paymentQuantity = quantityPersons * quarterNumber;
        double averagePayment = (double) total / paymentQuantity;
        double averageSalary = (int) (averagePayment * 10000 + 0.5) / 10000.0;
        System.out.println();
        System.out.printf("%-10s%-2.4f", "Средняя", averageSalary);
    }
}
