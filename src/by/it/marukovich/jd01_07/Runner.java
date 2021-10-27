package by.it.marukovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var firstScalar = new Scalar(123.456);
        Var secondScalar = new Scalar("1234.5678");
        System.out.println(firstScalar.toString());
        System.out.println(secondScalar.toString());
        double[] doubles = {1,2,3,4,5};
        Var firsVector = new Vector(doubles);
        doubles[0]=1234;
    }
}
