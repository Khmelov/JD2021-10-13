/*
            В классе TaskB (пакет by.it.family.jd01_02) создайте Scanner и методы:
            static void step1()
            static void step2(int month)
            static void step3(double a, double b, double c)
            вызовите их один раз из метода main. Эти методы решают такие задачи:
         1. step1() выводит числа от 1 до 25 в виде матрицы N x N слева направо и
            сверху вниз (т.е. N = 5). После каждого числа один пробел.
         2. В main ввести с консоли через объект типа Scanner число от 1 до 12 и с
            ним вызвать метод step2(int month), который выводит на консоль русское
            название месяца строчными буквами, соответствующего этому числу через
            switch. Сообщить об ошибке “нет такого месяца” для некорректных чисел
            во вводе (это должна быть default – ветка для switch).
         3. Рассчитайте и выведите корни (или один корень) квадратного уравнения.
            Если корня нет, то нужно вывести сообщение “корней нет”.
            Параметры (a b c) уравнения нужно вводить в main через тот же Scanner и
            затем передавать в метод step3(double a, double b, double c).
            Для извлечения 𝐷 используйте метод Math.sqrt(дискриминант)
_______________________________________________________________________________________________________________________
*/
package by.it.karpovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step1();
        step2(month);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);
    }


    static void step1() {
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
        }
    }

    static void step2(int month) {
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (dis < 0) {
            System.out.println("корней нет");
        } else /*if (dis==0)*/ {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            if (x1 == x2) {
                System.out.println(x1);
            } else {
                System.out.println(x1 + " " + x2);
            }
        }

    }


}