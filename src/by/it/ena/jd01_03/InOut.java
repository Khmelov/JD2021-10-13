package by.it.ena.jd01_03;

public class InOut {
    static double[ ] getArray(String line){
       String[] strArray= line.split(" ");
       double [] res= new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res[i]=Double.parseDouble(strArray[i]);
        }
       return res;
    }

    static void printArray(double[ ] array){
        for(double element:array){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] array, String name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,array[i]);
            if( (i+1) % columnCount==0 || i+1==array.length)
                System.out.println();
        }
    }

}
