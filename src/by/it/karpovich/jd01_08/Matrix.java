package by.it.karpovich.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.karpovich.jd01_08.Patterns.*;


public class Matrix extends Var {
    private final double[][] value;

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
        } else {
            assert other instanceof Matrix;
            if (this.value.length ==
                    ((Matrix) other).value.length & this.value[0].length ==
                    ((Matrix) other).value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(result);
            }
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
        } else if (other instanceof Matrix && this.value.length ==
                ((Matrix) other).value.length & this.value[0].length ==
                ((Matrix) other).value[0].length) {
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
        }
        if ((other instanceof Vector) && (this.value[0].length == ((Vector) other).getValue().length)) {
            double[] result = new double[this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i] = result[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(result);
        }
        assert other instanceof Matrix;
        if (this.value.length == ((Matrix) other).value.length & this.value[0].length == ((Matrix) other).value[0].length) {
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
        int i = 0;
        int j = 0;
        Pattern patternExtractor = Pattern.compile(PATTERN_EXTRACTOR);
        Matcher matcherExtractor = patternExtractor.matcher(stringValue);
        Pattern patternRightBracket = Pattern.compile(PATTERN_RIGHT_BRACKET);
        Matcher matcherRightBracket = patternRightBracket.matcher(stringValue);
        Matcher matcherFinder = patternExtractor.matcher(stringValue);
        while (matcherRightBracket.find()) {
            j++;
        }
        j = j - 1;
        System.out.println(j);
        while (matcherExtractor.find()) {
            i++;
        }
        int k = i / j;
        System.out.println(k);
        double[][] resMatrix = new double[j][k];
        int l = k - 1;
        k = 0;
        j = 0;
        while (matcherFinder.find()) {
            resMatrix[j][k] = Double.parseDouble(matcherFinder.group());
            System.out.println(j + INDENTED_STRING + k + INDENTED_STRING_LARGE + resMatrix[j][k]);
            if (k == l) {
                j++;
                k = 0;
            } else {
                k++;
            }
        }
        this.value = resMatrix;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int i = 0;
        out.append(LEFT_BRACKET);
        String text = EMPTY_STRING;
        for (double[] arr : value) {
            out.append(text);
            text = INDENTED_COMMA;
            out.append(LEFT_BRACKET);
            String count = EMPTY_STRING;
            for (double arr1 : value[i]) {
                out.append(count);
                out.append(arr1);
                count = INDENTED_COMMA;
            }
            i++;
            out.append(RIGHT_BRACKET);
        }
        out.append(RIGHT_BRACKET);
        return out.toString();
    }
}