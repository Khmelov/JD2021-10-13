package by.it.shcharbunou.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class TaskC2 {

    public static void main(String[] args) {

    }

    private static Set<?> getCross(Set<?> ... setsArray) {
        Set<?> crossSet = new HashSet<>(setsArray[0]);
        for (int i = 0; i < setsArray.length; i++) {
            crossSet.retainAll(setsArray[i]);
        }
        return crossSet;
    }

    private static Set<?> getUnion(Set<?> ... setsArray) {
        Set<?> unionSet = new HashSet<>(setsArray[0]);
        for (int i = 0; i < setsArray.length; i++) {
            unionSet.addAll((Set)setsArray[i]);
        }
        return unionSet;
    }
}
