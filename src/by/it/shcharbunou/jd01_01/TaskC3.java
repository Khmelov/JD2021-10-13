package by.it.shcharbunou.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int humanWeight = inputHumanWeight(scanner);
        double humanWeightOnMars = getWeight(humanWeight);
        printAnswer(humanWeightOnMars);
    }

    private static int inputHumanWeight(Scanner scanner) {
        boolean isCorrect;
        int humanWeight = 0;
        System.out.println("Input human's weight on the Earth:");
        do {
            isCorrect = true;
            try {
                humanWeight = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("The entered variable must be integer. Try again:");
                isCorrect = false;
            }
            if (humanWeight <= 0) {
                System.out.println("A person's weight cannot be negative. Try again:");
                isCorrect = false;
            } else if (humanWeight > 200) {
                System.out.println("I don't believe you weigh that much. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        return humanWeight;
    }

    private static double getWeight(int weightOnEarth) {
        final double G_ON_EARTH = 9.81;
        final double G_ON_MARS = 3.86;
        double weightOnMars = (weightOnEarth / G_ON_EARTH) * G_ON_MARS;
        weightOnMars *= 1000;
        long tempWeightVariable = (long) weightOnMars;
        if (tempWeightVariable % 10 >= 5) {
            tempWeightVariable = tempWeightVariable / 10 + 1;
        } else {
            tempWeightVariable /= 10;
        }
        weightOnMars = (double) (tempWeightVariable);
        weightOnMars /= 100;
        return weightOnMars;
    }

    private static void printAnswer(double answer) {
        System.out.println("Human's weight on Mars: " + answer);
    }
}
