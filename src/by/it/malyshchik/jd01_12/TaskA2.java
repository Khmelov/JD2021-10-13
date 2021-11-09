package by.it.malyshchik.jd01_12;

import java.util.*;

public class TaskA2 {
//    В main класса TaskA2 определите два множества (a и b) на основе целых чисел.
//    Создайте статические методы для определения пересечения множеств getCross и объединения множеств getUnion.
//    Покажите работу этих методов на примере двух разных множеств (например, HashSet a и TreeSet b).
public static void main(String[] args) {
    Integer[] array1 = {2, 2, 56, 3, 3, 4, 5, 6, 6, 7};
    List<Integer> arrayAsList1 = Arrays.asList(array1);
    List<Integer> arrayAsList2 = Arrays.asList(9, 9, 8, 8, 7, 7, 6, 5, 4, 4);
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
