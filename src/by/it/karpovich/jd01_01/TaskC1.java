package by.it.karpovich.jd01_01;

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
        Scanner console = new Scanner(System.in);
        System.out.println("\n Please enter your number:");
        int x = console.nextInt();
        int y = console.nextInt();
        int Sum = x + y;
        System.out.println("Sum = " + Sum);
    }


}
