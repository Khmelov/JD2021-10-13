package by.it.karpovich.my_calculator;

public class Scalar extends Var {
    private final double value; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Scalar(double value) {
        this.value = value;
    }

    // Начало второго конструктора:
    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    // Начало третьего конструктора:
    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
