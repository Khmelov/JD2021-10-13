package by.it.antipov.jd01_07;

import java.util.Arrays;

public class Vector extends  Var{
    private  double []value;

    Vector (double []value) {
        this.value= Arrays.copyOf(value, value.length);
    }
    Vector(Vector vector){
        this.value= vector.value;

    }

    Vector (String strVector) {
      String strVector1 = strVector.replace("}"," ");
        String strVector2 = strVector1.replace("{"," ");
        String strVector3 = strVector2.trim();
        String []array=strVector3.split("[,]");
        double[] values=new double[array.length];
        for (int i = 0; i < array.length; i++) {
            values[i]=Double.parseDouble(array[i]);
        }
        this.value=values;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String devider="";
        for (double arr:value) {
            out.append(devider);
            out.append(arr);
            devider=", ";


        }
        out.append("}");
        return out.toString();
    }
}