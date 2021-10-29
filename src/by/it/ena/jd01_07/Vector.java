package by.it.ena.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[ ] value){
        this.value=Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector){
        this.value=vector.value;
    }

   // Vector(String strVector){
    //    this.value=
  // }


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
