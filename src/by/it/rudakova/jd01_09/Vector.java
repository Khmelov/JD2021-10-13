package by.it.rudakova.jd01_09;

import java.util.Arrays;


public class Vector extends Var {
    public double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replace(strVector.charAt(0), ' ');
        strVector = strVector.replace(strVector.charAt(strVector.length() - 1), ' ');
        String trimedString = strVector.trim();
        String[] strArray = trimedString.split(",");
        double[] newArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            newArray[i] = Double.parseDouble(strArray[i]);
        }
        this.value = newArray;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
            }
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum = sum + res[i];
            }
          Scalar newSum = new Scalar(sum);

            return newSum;
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                if (res[i] != 0) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                } else {
                    System.out.println("На ноль делить нельзя");
                    break;
                }
            }
            return new Vector(res);

        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]);
            if (i != value.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');

        return stringBuilder.toString();
    }
}
