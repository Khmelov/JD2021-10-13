package by.it.ena.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

     Vector(String strVector){
         strVector=strVector.replace("{", "")
         .replace("}", "")
         .replace(" ", "");
         String[] strArray = strVector.split("[,]");
         double[] newArray = new double[strArray.length];
         for (int i = 0; i < strArray.length; i++) {
             newArray[i] = Double.parseDouble(strArray[i]);
         }
         this.value = newArray;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
