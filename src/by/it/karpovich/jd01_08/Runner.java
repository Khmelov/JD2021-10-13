package by.it.karpovich.jd01_08;

import java.util.Arrays;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(-3.0);
        Var v = new Vector(new double[]{1, -2, 3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        for (Var var : Arrays.asList(s.add(s), s.sub(s), s.mul(s), s.div(s), v.add(v), v.sub(v), v.mul(v), v.div(v), m.add(m), m.sub(m), m.mul(m), m.mul(v))) {
            print(var); //выведет в консоль 6.0
        }
    }
}
