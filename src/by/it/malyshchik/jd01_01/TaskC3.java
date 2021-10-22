package by.it.malyshchik.jd01_01;
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

import  java.util.Scanner;
public class TaskC3 {
//    public class Main {
//        private static final double G_EARTH = 9.81;
//        private static final double G_MARS = 3.86;
////        public static void main(final String[] args) {
//            final Scanner scanner = new Scanner(System.in);
//            final int weight = scanner.nextInt();
////            System.out.format("%.2f%n", getWeight(weight));
//        }
////        public static double getWeight(final int weight) {
//            return weight * G_MARS / G_EARTH;
//        }
//    }
//    static void getWeight(int weight,  double gmars) {

//      static double getWeight(int weight){
//           double gmars = 3.86;
//           double gearth = 9.81;
//       double weight1 = weight * gmars/gearth;
//          double roundOff = (int) Math.round(weight1*100)/100;
//          return roundOff;
//    }
//        double mmars = weight/gmars;
////        double mearth = weight/gearth;
//        return mmars;
////        return mearth;
//    static void gWeight(int weight, double g){
//        double m = weight * 1.0 / g;
//        return m;
//    }
//    }
    public static void main(String[] args) {

        System.out.println("Ввод:");
        Scanner sc = new Scanner (System.in);
        int weight = sc.nextInt();
        System.out.println("Вывод:");

        System.out.println(getWeight(weight));
//        System.out.format("%.2f%n", getWeight(weight));
    }
    static double getWeight(int weight){
        double gmars = 3.86;
        double gearth = 9.81;
        double weight1 = weight * gmars/gearth;
        double roundOff = (int) Math.round(weight1*100)/100.0;
        return roundOff;
    }
}

//    public static void main(String[] args) {
//
//    }
//    static double mm=me/9.81*3.86;
//it mm100 = (int)mm*100;
//double delta = mm * 100 - mm100;
// if (delta >=0.5) {
//     return mm10 + 1)/100.0;
//         }
// re