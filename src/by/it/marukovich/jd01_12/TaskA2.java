package by.it.marukovich.jd01_12;


import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] array1={1,1,2,2,3,4,5,5,6,6,7};
        Integer[] array2={9,9,8,8,7,7,6,5,5,4};
        List<Integer> arrayList1 = Arrays.asList(array1);
        List<Integer> arrayList2 = Arrays.asList(9, 9, 8, 8, 7, 7, 6, 5, 5, 4);
        Set<Integer> hashSet = new HashSet<>(arrayList1);
        Set<Integer> treeSet = new HashSet<>(arrayList2);
        System.out.println("hashSet"+ hashSet);
        System.out.println("treeSet"+ treeSet);

    }
}
