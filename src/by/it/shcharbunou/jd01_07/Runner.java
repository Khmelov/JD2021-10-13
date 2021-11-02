package by.it.shcharbunou.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar doubleScalar = new Scalar(3.1415);
        Scalar scalar = new Scalar(doubleScalar);
        Scalar stringScalar = new Scalar("3.1415");
        double[] array = {1.0, 2.0, 4.0};
        Vector doubleVector = new Vector(array);
        Vector vector = new Vector(doubleVector);
        Vector stringVector = new Vector("{1.0, 2.0, 4.0}");
        double[][] twoDimensionalArray = {{1.0, 2.0}, {3.0, 4.0}};
        Matrix doubleMatrix = new Matrix(twoDimensionalArray);
        Matrix matrix = new Matrix(doubleMatrix);
        Matrix stringMatrix = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(doubleScalar);
        System.out.println(scalar);
        System.out.println(stringScalar);
        System.out.println(doubleVector);
        System.out.println(vector);
        System.out.println(stringVector);
        System.out.println(doubleMatrix);
        System.out.println(matrix);
        System.out.println(stringMatrix);
    }
}
