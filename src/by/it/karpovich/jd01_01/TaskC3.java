/*
Ускорение свободного падения на Земле и Марсе таково:
Марс 3.86
Земля 9.81

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
_______________________________________________________________________________________________________________________
*/

package by.it.karpovich.jd01_01;

import java.util.Scanner;

class TaskC3 {
    private static final double G_EARTH = 9.81;
    private static final double G_MARS = 3.86;

    public static void main(final String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("\n \t Please enter your weight (Kg) on planet Earth");
        int weight = console.nextInt();
        System.out.println("Your weight (earth): " + weight + " kg" + "\nYour weight (mars):");
        System.out.println(getWeight(weight));
    }

    public static double getWeight(int weight) {
        return (int) ((weight * G_MARS / G_EARTH) * 100 + 0.5) / 100.0;
    }
}

//______________________________________________________________________________________________________________________