package by.it.ena.jd01_07;

import java.util.Arrays;

class Matrix extends Var{
    private double[][] value;

    Matrix(double[ ][ ] value){
        this.value=Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix){
        this.value=matrix.value;
    }

   // Matrix(String strMatrix){
    //    this.value=
  //  }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        int k = 0;
        for (double[] v : value) {
            for (Double m : v) {
                k++;
                s = s.append(m.toString());
                if (k % value.length != 0) {
                    s.append(",");
                } else if (k != value.length * value.length) {
                    s.append("},{");
                } else {
                    s.append("}}");
                }
            }
        }
        return s.toString();
    }
}
