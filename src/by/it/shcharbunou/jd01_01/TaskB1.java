package by.it.shcharbunou.jd01_01;

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

import java.util.Scanner;

class TaskB1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isCorrect;
        int a = 0;
        System.out.println("Enter an integer from the keyboard in the range [-46339..46339]:");
        do {
            isCorrect = true;
            try {
                a = Integer.parseInt(input.next());
            } catch (Exception e) {
                System.out.println("The entered variable must be an integer. Try again:");
                isCorrect = false;
            }
            if ((a < -46339) || (a > 46339)) {
                System.out.println("The entered variable must be in the range [-46339..46339]. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        System.out.println(a * a);
    }
}
