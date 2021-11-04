package by.it.shcharbunou.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll(" ", "");
        strMatrix = strMatrix.substring(1, strMatrix.length() - 1);
        strMatrix = strMatrix.replaceAll("},", "} ");
        String rowsRegex = "[{][0-9.,+-]+[}]";
        Pattern pattern = Pattern.compile(rowsRegex);
        Matcher matcher = pattern.matcher(strMatrix);
        int rowsCount = findRowsCount(matcher);
        int columnsCount = findColumnsCount(strMatrix);
        double[][] matrix = new double[rowsCount][columnsCount];
        String[] rowsString = strMatrix.split(" ");
        fillMatrix(rowsString, matrix);
        this.value = matrix;
    }

    private void fillMatrix(String[] rowsString, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getRow(rowsString, i);
        }
    }

    private double[] getRow(String[] rowsString, int rowIndex) {
        rowsString[rowIndex] = rowsString[rowIndex].substring(1, rowsString[rowIndex].length() - 1);
        String[] temporaryRowStringArray = rowsString[rowIndex].split("[^0-9.+-]");
        double[] temporaryRowArray = new double[temporaryRowStringArray.length];
        for (int i = 0; i < temporaryRowArray.length; i++) {
            temporaryRowArray[i] = Double.parseDouble(temporaryRowStringArray[i]);
        }
        return temporaryRowArray;
    }

    private int findColumnsCount(String strMatrix) {
        int counter = 0;
        int i = 1;
        while (strMatrix.charAt(i) != '}') {
            if (strMatrix.charAt(i) == ',') {
                counter++;
            }
            i++;
        }
        counter++;
        return counter;
    }

    private int findRowsCount(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringMatrixPerformance = new StringBuilder();
        stringMatrixPerformance.append('{');
        for (int i = 0; i < value.length; i++) {
            stringMatrixPerformance.append('{');
            for (int j = 0; j < value[i].length; j++) {
                stringMatrixPerformance.append(value[i][j]);
                if (j != value[i].length - 1) {
                    stringMatrixPerformance.append(", ");
                }
            }
            stringMatrixPerformance.append('}');
            if (i != value.length - 1) {
                stringMatrixPerformance.append(", ");
            }
        }
        stringMatrixPerformance.append('}');
        return stringMatrixPerformance.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] additionMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < additionMatrix.length; i++) {
                System.arraycopy(this.value[i], 0, additionMatrix[i], 0, this.value[i].length);
            }
            for (int i = 0; i < additionMatrix.length; i++) {
                for (int j = 0; j < additionMatrix[i].length; j++) {
                    additionMatrix[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(additionMatrix);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] additionMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < additionMatrix.length; i++) {
                    System.arraycopy(this.value[i], 0, additionMatrix[i], 0, this.value[i].length);
                }
                for (int i = 0; i < additionMatrix.length; i++) {
                    for (int j = 0; j < additionMatrix[i].length; j++) {
                        additionMatrix[i][j] += ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(additionMatrix);
            } else {
                return super.add(other);
            }
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] deductedMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < deductedMatrix.length; i++) {
                System.arraycopy(this.value[i], 0, deductedMatrix[i], 0, this.value[i].length);
            }
            for (int i = 0; i < deductedMatrix.length; i++) {
                for (int j = 0; j < deductedMatrix[i].length; j++) {
                    deductedMatrix[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(deductedMatrix);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] deductedMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < deductedMatrix.length; i++) {
                    System.arraycopy(this.value[i], 0, deductedMatrix[i], 0, this.value[i].length);
                }
                for (int i = 0; i < deductedMatrix.length; i++) {
                    for (int j = 0; j < deductedMatrix[i].length; j++) {
                        deductedMatrix[i][j] -= ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(deductedMatrix);
            } else {
                return super.sub(other);
            }
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] multipliedMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < multipliedMatrix.length; i++) {
                System.arraycopy(this.value[i], 0, multipliedMatrix[i], 0, this.value[i].length);
            }
            for (int i = 0; i < multipliedMatrix.length; i++) {
                for (int j = 0; j < multipliedMatrix[i].length; j++) {
                    multipliedMatrix[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(multipliedMatrix);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] multipliedVector = new double[this.value.length];
                Arrays.fill(multipliedVector, 0);
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < multipliedVector.length; j++) {
                        multipliedVector[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(multipliedVector);
            } else {
                return super.mul(other);
            }
        } else if (other instanceof Matrix) {
            if (this.value[0].length == ((Matrix) other).value.length) {
                double[][] multipliedMatrix = new double[this.value.length][((Matrix) other).getValue()[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).getValue()[i].length; j++) {
                        for (int k = 0; k < ((Matrix) other).getValue().length; k++) {
                            multipliedMatrix[i][j] = multipliedMatrix[i][j] + this.value[i][k]
                                    * ((Matrix) other).getValue()[k][j];
                        }
                    }
                }
                return new Matrix(multipliedMatrix);
            } else {
                return super.mul(other);
            }
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] dividedMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < dividedMatrix.length; i++) {
                System.arraycopy(this.value[i], 0, dividedMatrix[i], 0, this.value[i].length);
            }
            for (double[] row : dividedMatrix) {
                if (Arrays.asList(row).contains(0)) {
                    return super.div(other);
                }
            }
            for (int i = 0; i < dividedMatrix.length; i++) {
                for (int j = 0; j < dividedMatrix[i].length; j++) {
                    dividedMatrix[i][j] /= ((Scalar) other).getValue();
                }
            }
            return new Matrix(dividedMatrix);
        } else {
            return super.div(other);
        }
    }

    public double[][] getValue() {
        return value;
    }
}
