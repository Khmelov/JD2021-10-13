package by.it.malyshchik.jd01_01;

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
//import java.util.Scanner
class TaskC2 {
    public static void main(String[] args) {
        System.out.println("Введите два числа");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int ij = i+j;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(j));

        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toHexString(j));

        System.out.println(Integer.toOctalString(i));
        System.out.println(Integer.toOctalString(j));

        String a1 = Integer.toBinaryString(i);
        String b1 = Integer.toBinaryString(j);
//        int a2 = Integer.parseInt (a.trim ());
//        int b2 = Integer.parseInt (b.trim ());
        String c1 = Integer.toBinaryString(Integer.parseInt(a1, 2) + Integer.parseInt(b1, 2));
//        int c = a2 + b2;

        String a2 = Integer.toHexString(i);
        String b2 = Integer.toHexString(j);
        String c2 = Integer.toHexString(Integer.parseInt(a2, 16) + Integer.parseInt(b2, 16));

        String a3 = Integer.toOctalString(i);
        String b3 = Integer.toOctalString(j);
        String c3 = Integer.toOctalString(Integer.parseInt(a3, 8) + Integer.parseInt(b3, 8));

        System.out.println("DEC:"+i+ "+" +j+ "=" +ij);
        System.out.println("BIN:"+a1+ "+" +b1+ "=" + c1);
        System.out.println("HEX:"+a2+ "+" +b2+ "=" + c2);
        System.out.println("OCT:"+a3+ "+" +b3+ "=" + c3);


    }


}
