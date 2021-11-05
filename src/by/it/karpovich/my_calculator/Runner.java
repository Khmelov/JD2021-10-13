package by.it.karpovich.my_calculator;

import by.it.karpovich.jd01_08.Matrix;
import by.it.karpovich.jd01_08.Scalar;
import by.it.karpovich.jd01_08.Var;
import by.it.karpovich.jd01_08.Vector;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    private static void print(by.it.karpovich.jd01_08.Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите скаляр: ");
        double s_1 = scanner.nextDouble();
        System.out.println("Введите Вектор из нескольких чисел: ");
        double v_1 = scanner.nextDouble();
    //    System.out.println("Введите числа матрицы");
    //    Double m_1 = scanner.nextDouble();
        by.it.karpovich.jd01_08.Var s = new Scalar(s_1);
        by.it.karpovich.jd01_08.Var v = new Vector(new double[]{v_1});
        by.it.karpovich.jd01_08.Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        for (Var var : Arrays.asList(s.add(s), s.sub(s), s.mul(s), s.div(s), v.add(v), v.sub(v), v.mul(v), v.div(v), m.add(m), m.sub(m), m.mul(m), m.mul(v))) {
            print(var);
        }
    }
}
