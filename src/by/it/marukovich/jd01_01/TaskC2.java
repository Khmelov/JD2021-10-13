package by.it.marukovich.jd01_01;

import java.math.BigInteger;
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
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int Sum = i + j;
        String convert_i = Integer.toBinaryString(i);
        String convert_i1 = Integer.toHexString(i);
        String convert_i2 = Integer.toOctalString(i);
        String convert_j = Integer.toBinaryString(j);
        String convert_j1 = Integer.toHexString(j);
        String convert_j2 = Integer.toOctalString(j);
        String convert_sum = Integer.toBinaryString(Sum);
        String convert_sum1 = Integer.toHexString(Sum);
        String convert_sum2 = Integer.toOctalString(Sum);
        System.out.println("DEC:" + i + "+" + j + "=" + Sum);
        System.out.println("BIN:" + convert_i + "+" + convert_j + "=" + convert_sum);
        System.out.println("HEX:" + convert_i1 + "+" + convert_j1 + "=" + convert_sum1);
        System.out.println("OCT:" + convert_i2 + "+" + convert_j2 + "=" + convert_sum2);

    }

}
