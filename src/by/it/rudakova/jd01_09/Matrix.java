package by.it.rudakova.jd01_09;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double value[][];

    public Matrix(double[][] otherValue) {
        this.value = otherValue;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {
        StringBuilder line = new StringBuilder(strMatrix);
        Pattern pattern = Pattern.compile("[\\d]+[.]*[\\d]*");
        Matcher matcher = pattern.matcher(line);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] arrayGroups = new String[counter];
        matcher.reset();
        int i = 0;
        while (matcher.find()) {
            arrayGroups[i] = strMatrix.substring(matcher.start(), matcher.end());
            i++;
        }
        int lengthArray = (int) Math.sqrt(arrayGroups.length);
        double[][] newArray = new double[lengthArray][lengthArray];
        i = 0;
        for (int j = 0; j < newArray.length; j++) {
            for (int k = 0; k < newArray.length; k++) {
                newArray[j][k] = Double.parseDouble(arrayGroups[i]);
                i++;
            }
        }
        value = newArray;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[i].length; k++) {
                    res[i][k] = res[i][k] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix) {
            double[][] res = copyMatrix(((Matrix) other).value);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[i].length; k++) {
                    res[i][k] = value[i][k] + ((Matrix) other).value[i][k];
                }
            }
            return new Matrix(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[i].length; k++) {
                    res[i][k] = res[i][k] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix) {
            double[][] res = copyMatrix(((Matrix) other).value);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res.length; k++) {
                    res[i][k] = value[i][k] - ((Matrix) other).value[i][k];
                }
            }
            return new Matrix(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[i].length; k++) {
                    res[i][k] = res[i][k] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            double[] newRes = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                double sum = 0;
                for (int k = 0; k < res[i].length; k++) {
                    sum = sum + res[i][k] * ((Vector) other).value[k];
                    newRes[i] = sum;
                }
            }
            return new Vector(newRes);
        }

        if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] res = copyMatrix(value);
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[i].length; k++) {
                    double sum = 0;
                    for (int j = 0; j < res.length; j++) {
                        var element1 = value[k][j];
                        var element2 = otherMatrix.value[j][i];
                        sum = sum + element1 * element2;
                    }
                    res[k][i] = sum;
                }
            }
            return new Matrix(res);
        }

        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append('{');
            for (int k = 0; k < value[0].length; k++) {
                stringBuilder.append(value[i][k]);
                if (k != value[0].length - 1) {
                    stringBuilder.append(", ");
                }
            }
            if (i == value.length - 1) {
                stringBuilder.append("}}");
            } else {
                stringBuilder.append("}, ");
            }
        }
        return stringBuilder.toString();
    }

    private double[][] copyMatrix(double[][] source) {
        double[][] newArray = new double[source.length][source[0].length];
        for (int i = 0; i < newArray.length; i++) {
            for (int k = 0; k < newArray[0].length; k++) {
                newArray[i][k] = source[i][k];
            }
        }
        return newArray;
    }
}
