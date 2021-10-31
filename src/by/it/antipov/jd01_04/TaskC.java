package by.it.antipov.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        double []array={-13.418983719447954, -12.524750283296655, -11.191181597773728, -10.957611789405108, -9.47510036012411, -8.808814263764665, -6.841348582027262, -3.675525727393497, -2.3561058431193835, -1.5579700056475474, 0.6066826858137908, 6.58193259947911, 7.4804299856442675, 8.987518261692358, 13.16409793017927};
        binarySearch(array,-12.524750283296655);
    }
    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] strings = line.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf(" V[%1$-1d]=%2$-4.4f", j, array[j]);
            if ((j + 1) % 5 == 0 | j == array.length - 1) {
                System.out.println();
            }

        }
        double left=array[0];
        double right=array[array.length-1];
        for (int a = 0; a < array.length - 1; a++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    double buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                }
            }
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf(" V[1$-1d]=%2$-4.4f", j, array[j]);
            if ((j + 1) % 4 == 0 | j == array.length - 1) {
                System.out.println();}
        }
        System.out.println("first element="+binarySearch(array,left));
        System.out.println("last element="+binarySearch(array,right));


    }
    static int binarySearch (double[]array,double value){
        int n= (array.length-1)/2;
        int counter=0;
        double nD = (double)(array.length-1)/2;
        double dist = (array.length-1)/2;
        while (value!=array [n]){
            if (value>array[n])  {counter=counter+1;double k =nD;nD=((n+(nD+dist))/2);n= (int)(Math.round((n+(k+dist))/2));dist= dist/2;if (counter>Math.log(array.length)/Math.log(2)){System.out.println(array.length-1);n=array.length-1;break;}}
            if (value<array[n])  {counter=counter+1;double k =nD;nD=((n+(nD-dist))/2);n=(int)(Math.round((n+(k-dist))/2));dist= dist/2;if (counter>Math.log(array.length)/Math.log(2)){System.out.println(0);n=0;break;}}
            if (value==array [n]) {System.out.println(n);break;}

        }
        return n;
    }
}