package by.it.karpovich.jd01_01;

import java.util.Scanner;
/*
Выводим квадрат числа
Напишите программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
Для считывания данных с клавиатуры используйте метод nextInt() объекта класса Scanner.

Создать Scanner можно так:
Scanner sc=new Scanner(System.in);

Прочитать число можно так:
int i=sc.nextInt();

Требования:
1. Программа должна выводить текст.
2. В программе необходимо создать объект типа Scanner.
3. Программа должна считывать число типа Int с клавиатуры.
4. Программа должна выводить квадрат считанного числа.

 */

class TaskB1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("\n Please enter your number:");
        int a = console.nextInt();
        System.out.println("Output:\t" + a * a);
    }

}
