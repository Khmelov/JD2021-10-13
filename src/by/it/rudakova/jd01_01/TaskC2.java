package by.it.rudakova.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int sum = firstNumber + secondNumber;
        System.out.println("DEC:" + firstNumber + "+" + secondNumber + "=" + sum);

        String binaryFirstNumber = Integer.toString(firstNumber, 2);
        String binarySecondNumber = Integer.toString(secondNumber, 2);
        String binarySum = Integer.toString(sum, 2);
        System.out.println("BIN:" + binaryFirstNumber + "+" + binarySecondNumber + "=" + binarySum);

        String hexFirstNumber = Integer.toString(firstNumber, 16);
        String hexSecondNumber = Integer.toString(secondNumber, 16);
        String hexSum = Integer.toString(sum, 16);
        System.out.println("HEX:" + hexFirstNumber + "+" + hexSecondNumber + "=" + hexSum);

        String octFirstNumber = Integer.toString(firstNumber, 8);
        String octSecondNumber = Integer.toString(secondNumber, 8);
        String octSum = Integer.toString(sum, 8);
        System.out.println("OCT:" + octFirstNumber + "+" + octSecondNumber + "=" + octSum);
    }
}
