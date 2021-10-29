package by.it.karpovich.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    // Начало второго конструктора:
    public Vector(Vector vector) {
        this.value = vector.value;
    }

    // Начало третьего конструктора:
    public Vector(String strVector) {
        String[] strArr = strVector.split("[/{, }]+");
        strArr = Arrays.copyOfRange(strArr, 1, strArr.length);
        double[] array = new double[strArr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArr[i]);
        }
        this.value = array;
    }


    public String toString() {
        StringBuilder output = new StringBuilder("{");
        String limiter = "";
        for (double out : value) {
            output.append(limiter);
            //Метод java.lang.StringBuilder.append () используется для добавления
            // строкового представления некоторого аргумента в последовательность.
            output.append(out);
            limiter = ", ";
        }
        output.append("}");
        return output.toString();
    }
}