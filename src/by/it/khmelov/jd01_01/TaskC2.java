package by.it.khmelov.jd01_01;

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
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String dec = "DEC:" + a + "+" + b + "=" + (a + b);
        String bin = "BIN:" + Integer.toBinaryString(a) + "+" + Integer.toBinaryString(b) +
                "=" + Integer.toBinaryString(a + b);
        String hex = "HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) +
                "=" + Integer.toHexString(a + b);
        String oct = "OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) +
                "=" + Integer.toOctalString(a + b);

        System.out.println(dec);
        System.out.println(hex);
        System.out.println(bin);
        System.out.println(oct);
    }


}
