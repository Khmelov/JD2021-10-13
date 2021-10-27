package by.it.antipov.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        double []array= new double[36];
        double z;
        int j=0;
        int i=0;
        int k=0;
        double multiple=1;
        for (double x = 5.33; x <9; x=x+((9-5.33)/35),i++) {
            array[i]=Math.cbrt(x*x+4.5);
if (array[i]>3.5) j=j+1;
System.out.printf("array[%1d] = %1.5f   ",i,array[i]);
        }
        System.out.println("_______");
        double []array1= new double[j];
        for ( i= 0; i <=j ; i++) {
            if (array[i]>3.5) {++k; array1[k]=array[i]; System.out.println(array1[k]);}

multiple=multiple*array1[k];
        }
        double averageMultiple=Math.pow(multiple,1/j);
    }
}
