package by.it.shcharbunou.jd01_12;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new TreeSet<>();
        fillSet(setA);
        fillSet(setB);
        Set<Integer> unionSet = getUnion(setA, setB);
        Set<Integer> crossSet = getCross(setA, setB);
        printSet(setA);
        printSet(setB);
        printSet(unionSet);
        printSet(crossSet);
    }

    private static void printSet(Set<Integer> set) {
        System.out.println(set);
    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> crossSet = new HashSet<>(setA);
        crossSet.retainAll(setB);
        return crossSet;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        return unionSet;
    }

    private static void fillSet(Set<Integer> set) {
        Random random = new Random();
        final int MAX_SIZE = 100;
        final int MIN_SIZE = 30;
        final int MIN_VALUE = -200;
        final int MAX_VALUE = 200;
        int estimatedSize = random.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
        for (int i = 0; i < estimatedSize; i++) {
            set.add(random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
        }
    }
}
