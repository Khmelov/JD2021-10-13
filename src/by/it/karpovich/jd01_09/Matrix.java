package by.it.karpovich.jd01_09;

import java.util.Arrays;

import static by.it.karpovich.jd01_09.Patterns.LEFT_BRACKET;
import static by.it.karpovich.jd01_09.Patterns.RIGHT_BRACKET;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix value) {
        this.value = value.value;
    }

    public double[][] getValue() {
        return value;
    }

    public Matrix(String strMatrix) {
        String line = strMatrix.substring(2, strMatrix.length() - 2);
        String[] strArr = line.split("[}][,][ ]?[{]");
        double[][] outputArray = new double[strArr.length][strArr[0].split(",").length];
        for (int i = 0; i < strArr.length; i++) {
            String[] strArr2 = strArr[i].split(",");
            int k = 0;
            for (int j = 0; j < strArr2.length; j++) {
                outputArray[i][j] = Double.parseDouble(strArr2[k]);
                k++;
            }
        }
        this.value = outputArray;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] firstOperand = copyArray(this.value);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                for (int j = 0; j < firstOperand[i].length; j++) {
                    firstOperand[i][j] += secondOperand;
                }
            }
            return new Matrix(firstOperand);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length &&
                this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] firstOperand = copyArray(this.value);
            double[][] secondOperand = ((Matrix) other).value;
            for (int i = 0; i < firstOperand.length; i++) {
                for (int j = 0; j < firstOperand[i].length; j++) {
                    firstOperand[i][j] += secondOperand[i][j];
                }
            }
            return new Matrix(firstOperand);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return this.add(other.mul(new Scalar(-1)));
    }


    private double[][] copyArray(double[][] originalArray) {
        double[][] outputArray = new double[originalArray.length][originalArray[0].length];
        for (int i = 0; i < outputArray.length; i++) {
            for (int j = 0; j < outputArray[i].length; j++) {
//                outputArray[i][j] = this.value[i][j];
                outputArray[i] = Arrays.copyOf(originalArray[i], originalArray.length);
            }
        }
        return outputArray;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] firstOperand = copyArray(this.value);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                for (int j = 0; j < firstOperand[i].length; j++) {
                    firstOperand[i][j] *= secondOperand;
                }
            }
            return new Matrix(firstOperand);
        }
        if (other instanceof Vector && this.value.length == ((Vector) other).getValues().length) {
            double[][] firstOperand = copyArray(this.value);
            double[] secondOperand = ((Vector) other).getValues();
            double[] result = Helper.multiply(firstOperand, secondOperand);
            return new Vector(result);
        }
        if (other instanceof Matrix && this.value.length == ((Matrix) other).getValue().length &&
                this.value[0].length == ((Matrix) other).getValue()[0].length) {
            double[][] firstOperand = copyArray(this.value);
            double[][] secondOperand = ((Matrix) other).getValue();
            double[][] result = Helper.multiply(firstOperand, secondOperand);
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(LEFT_BRACKET);
        for (double[] doubles : value) {
            String delimiter = "";
            output.append(LEFT_BRACKET);
            for (double aDouble : doubles) {
                output.append(delimiter);
                output.append(aDouble);
                delimiter = ", ";
            }
            delimiter = "}, ";
            output.append(delimiter);
        }
        output.delete(output.length() - 2, output.length());
        output.append(RIGHT_BRACKET);
        return output.toString();
    }

}