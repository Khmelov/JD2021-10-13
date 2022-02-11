package by.it.ena.jd01_01;

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
    private static double G_EARTH = 9.81;
    private static double G_MARS = 3.86;

    public static void main(String[] args) {
        System.out.println("Ввод:");
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        System.out.println("Вывод: ");
        System.out.println(getWeight(weight));

    }

    public static double getWeight(int weight) {
        double weight1 = weight * G_MARS / G_EARTH; //(ctrl alt c константа )
        //int weight2 = (int) weight1 * 100;
      //  double delta = weight1 * 100.0 - weight2;
       // if (delta >= 0.5) {
           // return (weight2 + 1) / 100.0;
      //  }
      //  return weight2 / 100.0;
        //делала так, как показывали на занятии, в итоге получается 29.01
        double weight2=(double)Math.round(weight1*100.0)/100.0;
        return weight2;
    }
}