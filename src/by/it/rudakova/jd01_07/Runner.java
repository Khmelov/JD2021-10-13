package by.it.rudakova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar firstScalar=new Scalar(123.456);
        Scalar secondScalar=new Scalar("1234.5678");
        System.out.println(firstScalar.toString());
        System.out.println(secondScalar.toString());

       double[] arrayVector={1.0,2.0,4.0};
       Vector vectorsArray=new Vector(arrayVector);
       Vector stringVector=new Vector("{1.0,2.0,4.0}");
       System.out.println(vectorsArray.toString());
       System.out.println(stringVector.toString());

       double[][] array={{1.0,2.0},{3.0,4.0}};
       Matrix matrixArray=new Matrix(array);
       Matrix stringMatrix=new Matrix("{{1.0,2.0},{3.0,4.0}}");
        System.out.println(matrixArray.toString());
        System.out.println(stringMatrix.toString());

    }
}
