package by.it.karpovich.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {
        Integer[] array1 = {1, 1, 34, 2, 2, 3, 4, 5, 5, 6, 6, 7};
        List<Integer> arrayAsList1 = Arrays.asList(array1);
        List<Integer> arrayAsList2 = Arrays.asList(9, 9, 8, 8, 7, 7, 6, 5, 5, 4);
        Set<Integer> hashSet = new HashSet<>(arrayAsList1);
        Set<Integer> treeSet = new TreeSet<>(arrayAsList2);
        System.out.println("hashset: " + hashSet);
        System.out.println("treeset: " + treeSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println("union: " + union);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.println("cross: " + cross);
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }


    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }


}
