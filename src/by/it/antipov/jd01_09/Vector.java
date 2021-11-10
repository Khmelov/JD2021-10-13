package by.it.antipov.jd01_09;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);}
        else if ((other instanceof Vector)&(this.value.length == ((Vector) other).value.length)) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);}
        else if ((other instanceof Vector)&(this.value.length == ((Vector) other).value.length)) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);}
        else if ((other instanceof Vector)&(this.value.length == ((Vector) other).value.length)) {
            double[] result = Arrays.copyOf(value, value.length);
            double result1=0;
            for (int j = 0; j < result.length; j++) {
                result[j] = result[j] * ((Vector) other).value[j];
                result1= result1+result[j];
            }
            return new Scalar(result1);}
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);}
        return super.div(other);

    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String strVector1 = strVector.replace("}", " ");
        String strVector2 = strVector1.replace("{", " ");
        String strVector3 = strVector2.trim();
        String[] array = strVector3.split("[,]");
        double[] values = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            values[i] = Double.parseDouble(array[i]);
        }
        this.value = values;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String devider = "";
        for (double arr : value) {
            out.append(devider);
            out.append(arr);
            devider = ", ";


        }
        out.append("}");
        return out.toString();
    }

}