package by.it.shcharbunou.jd01_12;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {

    public static void main(String[] args) {

    }

    @SuppressWarnings("unchecked")
    private static <T> Set<T> getCross(Set<? extends T> ... setsArray) {
        Set<T> crossSet = new HashSet<>(setsArray[0]);
        for (int i = 1; i < setsArray.length; i++) {
            crossSet.retainAll(setsArray[i]);
        }
        return crossSet;
    }

    @SuppressWarnings("unchecked")
    private static <T> Set<T> getUnion(Set<? extends T> ... setsArray) {
        Set<T> unionSet = new HashSet<>(setsArray[0]) {

            @Override
            public boolean addAll(Collection<? extends T> c) {
                T[] collectionArray = (T[]) c.toArray();
                return true;
            }
        };
        for (int i = 1; i < setsArray.length; i++) {
            unionSet.addAll(setsArray[i]);
        }
        return unionSet;
    }
}
