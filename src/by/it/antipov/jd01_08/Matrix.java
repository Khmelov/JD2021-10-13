package by.it.antipov.jd01_08;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Matrix extends Var {
    private double[][] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if ((other instanceof Matrix) & ((this.value.length == ((Matrix) other).value.length) & (this.value[0].length == ((Matrix) other).value[0].length))) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if ((other instanceof Matrix) & ((this.value.length == ((Matrix) other).value.length) & (this.value[0].length == ((Matrix) other).value[0].length))) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if ((other instanceof Vector) & (this.value[0].length == ((Vector) other).getValue().length)) {
            double[] result = new double[this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i] = result[i] + this.value[i][j] * ((Vector) other).getValue()[i];
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix&((this.value.length == ((Matrix) other).value.length) & (this.value[0].length == ((Matrix) other).value[0].length))) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] = result[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }

            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String stringValue) {
        int j = 0;
        int i = 0;
        Pattern pattern1 = Pattern.compile("-?[0-9]+(\\.?[0-9]+)?");
        Matcher matcher1 = pattern1.matcher(stringValue);
        Pattern pattern2 = Pattern.compile("[\\}]");
        Matcher matcher2 = pattern2.matcher(stringValue);
        Matcher matcher3 = pattern1.matcher(stringValue);
        while (matcher2.find()) {
            j++;
        }
        j = j - 1;
        System.out.println(j);
        while (matcher1.find()) {
            i++;
        }
        int k = i / j;
        System.out.println(k);
        double[][] resMatrix = new double[j][k];
        int l = k - 1;
        k = 0;
        j = 0;
        while (matcher3.find()) {
            resMatrix[j][k] = Double.parseDouble(matcher3.group());
            System.out.println(j + " " + k + "   " + resMatrix[j][k]);
            if (k == l) {
                j++;
                k = 0;
            } else if (k != l) {
                k++;
            }

        }
        this.value = resMatrix;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int i = 0;
        out.append("{");
        String devider1 = "";
        for (double[] arr : value) {
            out.append(devider1);
            devider1 = ", ";
            out.append("{");
            String devider = "";
            for (double arr1 : value[i]) {
                out.append(devider);
                out.append(arr1);
                devider = ", ";


            }
            i++;
            out.append("}");
        }
        out.append("}");
        return out.toString();
    }
}
