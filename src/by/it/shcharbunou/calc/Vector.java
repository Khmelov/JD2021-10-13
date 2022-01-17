package by.it.shcharbunou.calc;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String regex = "[^0-9.+-]";
        String noSpacesStrVector = strVector.replaceAll(" ", "");
        noSpacesStrVector = noSpacesStrVector.substring(1, noSpacesStrVector.length() - 1);
        String[] stringValues = noSpacesStrVector.split(regex);
        double[] doublesArray = new double[stringValues.length];
        for (int i = 0; i < doublesArray.length; i++) {
            doublesArray[i] = Double.parseDouble(stringValues[i]);
        }
        this.value = doublesArray;
    }

    @Override
    public String toString() {
        StringBuilder stringArrayPerformance = new StringBuilder();
        stringArrayPerformance.append('{');
        for (int i = 0; i < value.length; i++) {
            stringArrayPerformance.append(value[i]);
            if (i != value.length - 1) {
                stringArrayPerformance.append(", ");
            }
        }
        stringArrayPerformance.append('}');
        return stringArrayPerformance.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] additionVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < additionVector.length; i++) {
                additionVector[i] += ((Scalar) other).getValue();
            }
            return new Vector(additionVector);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] additionVector = Arrays.copyOf(value, value.length);
                for (int i = 0; i < additionVector.length; i++) {
                    additionVector[i] += ((Vector) other).value[i];
                }
                return new Vector(additionVector);
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
            double[] deductedVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < deductedVector.length; i++) {
                deductedVector[i] -= ((Scalar) other).getValue();
            }
            return new Vector(deductedVector);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] additionVector = Arrays.copyOf(value, value.length);
                for (int i = 0; i < additionVector.length; i++) {
                    additionVector[i] -= ((Vector) other).value[i];
                }
                return new Vector(additionVector);
            } else {
                return super.add(other);
            }
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] multipliedVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < multipliedVector.length; i++) {
                multipliedVector[i] *= ((Scalar) other).getValue();
            }
            return new Vector(multipliedVector);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double multipliedScalar = 0;
                for (int i = 0; i < this.value.length; i++) {
                    multipliedScalar += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(multipliedScalar);
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
            double[] dividedVector = Arrays.copyOf(value, value.length);
            if (!Arrays.asList(dividedVector).contains(0)) {
                for (int i = 0; i < dividedVector.length; i++) {
                    dividedVector[i] /= ((Scalar) other).getValue();
                }
            } else {
                return super.div(other);
            }
            return new Vector(dividedVector);
        } else {
            return super.div(other);
        }
    }

    public double[] getValue() {
        return value;
    }
}
