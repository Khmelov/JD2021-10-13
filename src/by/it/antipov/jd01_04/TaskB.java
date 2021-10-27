package by.it.antipov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double sumSalaries = 0;
        double totalSalary =0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surnames = new String[n];
        int[][] salaries = new int[n][4];
        for (int i = 0; i < n; i++) {
            surnames[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j]= sc.nextInt();
            }
            }
        System.out.println("Фамилия   Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        for (int i = 0; i < n; i++) {System.out.println();
            System.out.print(surnames[i]);
            for (int j = 0; j <4 ; j++) {
                System.out.printf(" %1$9d ",salaries[i][j]);
                sumSalaries=sumSalaries+salaries[i][j];
            }
System.out.print("    "+sumSalaries);
            sumSalaries=0;

            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sumSalaries=sumSalaries+salaries[i][j];
            }

        }
        System.out.println();
        System.out.println("Итого "+sumSalaries);
        System.out.println("Средняя "+sumSalaries/n/4);
        }
        }


