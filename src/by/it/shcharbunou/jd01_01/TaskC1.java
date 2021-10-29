package by.it.shcharbunou.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
        int firstNum, secondNum, amount;
        firstNum = inputNum(scanner);
        secondNum = inputNum(scanner);
        amount = findAmount(firstNum, secondNum);
        printAnswer(amount);
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

    private static void printAnswer(int answer) {
        System.out.println("Sum = " + answer);
    }
}
