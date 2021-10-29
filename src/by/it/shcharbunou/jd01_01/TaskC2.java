package by.it.shcharbunou.jd01_01;

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
        int firstNum, secondNum, amount;
        firstNum = inputNum(scanner);
        secondNum = inputNum(scanner);
        amount = findAmount(firstNum, secondNum);
        printAnswer(firstNum, secondNum, amount);
    }

    private static int inputNum(Scanner scanner) {
        int num = 0;
        boolean isCorrect;
        System.out.println("Enter an integer from the keyboard in the range [-1073741823..1073741823]:");
        do {
            isCorrect = true;
            try {
                num = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("The entered variable must be an integer. Try again:");
                isCorrect = false;
            }
            if ((num < -1073741823) || (num > 1073741823)) {
                System.out.println("The entered variable must be in the range [-1073741823..1073741823]. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        return num;
    }

    private static int findAmount(int firstNum, int secondNum) {
        return (firstNum + secondNum);
    }

    private static void printAnswer(int firstNum, int secondNum, int amount) {
        printDec(firstNum, secondNum, amount);
        printBin(firstNum, secondNum, amount);
        printHex(firstNum, secondNum, amount);
        printOct(firstNum, secondNum, amount);
    }

    private static void printDec(int firstNum, int secondNum, int amount) {
        System.out.println("DEC:" + firstNum + "+" + secondNum + "=" + amount);
    }

    private static void printBin(int firstNum, int secondNum, int amount) {
        System.out.println("BIN:" + Integer.toBinaryString(firstNum) + "+" + Integer.toBinaryString(secondNum) +
                "=" + Integer.toBinaryString(amount));
    }

    private static void printHex(int firstNum, int secondNum, int amount) {
        System.out.println("HEX:" + Integer.toHexString(firstNum) + "+" + Integer.toHexString(secondNum) +
                "=" + Integer.toHexString(amount));
    }

    private static void printOct(int firstNum, int secondNum, int amount) {
        System.out.println("OCT:" + Integer.toOctalString(firstNum) + "+" + Integer.toOctalString(secondNum) +
                "=" + Integer.toOctalString(amount));
    }
}
