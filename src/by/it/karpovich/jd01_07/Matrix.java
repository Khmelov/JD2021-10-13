package by.it.karpovich.jd01_07;

public class Matrix extends Var {
    private double[][] value; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Matrix(double[][] value) {
        this.value = value;
    }

    // Начало второго конструктора:
    public Matrix(Matrix value) {
        this.value = value.value;
    }

    // Начало третьего конструктора:
    public Matrix(String strMatrix) {
        String line = strMatrix.substring(2, strMatrix.length() - 2);
        String[] strArrI = line.split("[}][,][{]");
        double[][] outputArray = new double[strArrI.length][strArrI[0].split(",").length];
        for (int i = 0; i < strArrI.length; i++) {
            String[] strArrJ = strArrI[i].split(",");
            int k = 0;
            for (int j = 0; j < strArrJ.length; j++) {
                outputArray[i][j] = Double.parseDouble(strArrJ[k]);
                k++;
            }
        }
        this.value = outputArray;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            String limiter = "";
            //Метод java.lang.StringBuilder.append () используется для добавления
            // строкового представления некоторого аргумента в последовательность.
            output.append("{");
            for (int j = 0; j < value[i].length; j++) {
                output.append(limiter);
                output.append(value[i][j]);
                limiter = ", ";
            }
            limiter = "}, ";
            output.append(limiter);
        }
        output.delete(output.length() - 2, output.length());
        output.append("}");
        return output.toString();
    }

}