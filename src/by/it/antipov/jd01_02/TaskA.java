package by.it.antipov.jd01_02;
import java.net.SocketOption;
import java.util.Scanner;
public class TaskA {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int [] arr = new int[10];
        for (int i=0; i< arr.length;i=i+1){arr[i]=sc.nextInt();
            System.out.println(arr[i]+" ");
        }
        step1(arr);
        step2(arr);
        step3(arr);
        }
    static void step1 (int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int a=0;a< arr.length;a++){
            if (arr[a]>max) { max= arr[a];
            }
            if (arr[a]<min) { min= arr[a];
            }
        }
        System.out.println(min+" "+max);

    }
    static void step2 (int[] arr){
        double sumArr=0;
        for (int a=0;a< arr.length;a++) {sumArr = sumArr +arr[a];
        }
       double average = sumArr/arr.length;
        for (int a=0;a< arr.length;a++) {if(arr[a]<average) System.out.println(arr[a]) ;
        }
    }
    static void step3 (int[] arr){
        int min = arr[0];
        for (int a=0;a< arr.length;a++)
            if (arr[a]<min) {
                min = arr[a];
            }
        for (int a= arr.length-1;a>=0;a--){if (min == arr[a]) System.out.print(a+" "); }
    }
        }


