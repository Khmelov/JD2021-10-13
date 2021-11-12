package by.it.rudakova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] firstArray = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7};
        Integer[] secondArray = {9, 9, 8, 8, 7, 7, 6, 5, 5, 4};
        List<Integer> array1 = Arrays.asList(firstArray);
        List<Integer> array2 = Arrays.asList(secondArray);
        HashSet<Integer> hashSet = new HashSet<>(array1);
        HashSet<Integer> treeSet = new HashSet<>(array2);
        System.out.println("hashSet: " + hashSet);
        System.out.println("treeSet: " + treeSet);
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
