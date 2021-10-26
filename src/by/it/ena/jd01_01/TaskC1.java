package by.it.ena.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        //  Scanner sc = new Scanner(System.in);
        //   System.out.println("Enter an integer number 1");
        // int a = sc.nextInt();
        //  Scanner c = new Scanner(System.in);
        //  System.out.println("Enter an integer number 2");
        // int b = c.nextInt();
        //   int Sum = a + b;
        //   System.out.println("Sum = " + Sum);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int Sum = a + b;
        System.out.println("Sum = " + Sum);


    }
}