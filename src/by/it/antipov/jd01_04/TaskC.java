package by.it.antipov.jd01_04;

public class TaskC {
    public static void main(String[] args) {
double []array={-8,-4,2,3,4,5,6,7,8,9,10,11,13,14};
binarySearch(array,-4);
    }

    static int binarySearch (double[]array,double value){
        int n= (array.length-1)/2;
        double nD = (double)(array.length-1)/2;
double dist = (array.length-1)/2;
        for (int i = 0; i <Math.log(array.length)/Math.log(2); i++) {
if (value>array[n])  {nD=((n+(nD+dist))/2);n= (int)(Math.round((n+(nD+dist))/2));dist= dist/2;}
if (value<array[n])  {nD=((n+(nD-dist))/2);n=(int)(Math.round((n+(nD-dist))/2));dist= dist/2;}
if (value==array [n]) {System.out.println(n);break;}

        }
        return n;
    }
}
