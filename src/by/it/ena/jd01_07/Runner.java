package by.it.ena.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(3.14);
        Var v2=new Vector(new double[]{1.0,2.0,4.0});
        Var v3=new Matrix(new double[][]{{1.0,2.0},{3.0,4.0}});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }
}

