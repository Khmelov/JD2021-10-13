package by.it.antipov.jd01_04;

public class TaskC {
    public static void main(String[] args) {
double []array={-4,-8,2,3,4,5,6,7,8,9,10,11,13};
binarySearch(array,13);
    }

    static int binarySearch (double[]array,double value){
        int n= (array.length-1)/2;
        double nD = (double)(array.length-1)/2;
double dist = Math.abs((n-(array.length-1))/2);
        for (int i = 0; i <Math.log(array.length)/Math.log(2); i++) {
if (value>array[n]){if(i==0) {nD=(n+array.length-1)/2;n=(n+array.length-1)/2;} if(i!=0) {nD=((n+(nD+dist))/2);n= (int) ((n+(nD+dist))/2);dist= Math.abs((n-(dist))/2);}}
if (value<array[n]) {if (i==0) {nD=n/2;n=(n/2);} if(i!=0) {nD=((n+(nD+dist))/2);n=(int)((n+(nD-dist))/2);dist= Math.abs((n-(dist))/2);} }
if (value==array [n]) {System.out.println(n);break;}

        }
        return n;
    }
}
