package by.it.malyshchik.jd01_02;

public class TaskA {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        double avg = 0;
        for (int element : array) {
            avg += element;
        }
        avg = avg / array.length;
        for (int element : array) {
            if (element < avg)
                System.out.print(element);
        }

    }
     static void step3(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        for (int i = array.length-1;i>=0;i--) {
            if (array[i] == min)
            System.out.print(i + " ");

            }
        }
    }
}
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//
//         int[] array = new int[10];
//         for (int i = 0; i < array.length; i++) {
//             array[i] = sc.nextInt();
//         }
//         step1(array);
//         step2(array);
//     }
//
//
//      private static void step1(int[] array) {
//             int min = array[0];
//             int max = array[0];
//             for (int i = 0; i< array.length; i++){
//
//                 if (min<array[i]) {
//                     min=array[i];
//                 }
//                 if (max>array[i]) {
//                     max=array[i];
//                 }
//             }
//             System.out.println(min + " " + max);
//         }
//
//         static void step2(int[] array){
//         double avg = 0;
//         for (int i = 0; i< array.length; i++){
//             avg += array[i];
//         }
//        avg=avg/array.length;
//         for (int i = 0; i< array.length; i++) {
//             if (i < avg)
//                 System.out.print(i + " ");
//         }
//
//         }
//         static void step3(int[] arr){
//
//         }


