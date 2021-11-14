package by.it.shcharbunou.jd01_12;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class TaskC2 {

    public static void main(String[] args) {
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Number> e = getUnion(b, c);
        Set<Number> t = getCross(b, c);
        System.out.println(e);
        System.out.println(t);
    }

    @SuppressWarnings("unchecked")
    private static <T> Set<T> getCross(Set<? extends T>... setsArray) {
        Set<T> crossSet = new HashSet<T>(setsArray[0]) {

            @Override
            public boolean retainAll(Collection<?> c) {
                T[] collectionArray = (T[]) c.toArray();
                boolean isContains;
                for (T collectionElement : collectionArray) {
                    isContains = false;
                    for (T thisCollectionElement : this) {
                        if (compareTo(collectionElement, thisCollectionElement) == 0) {
                            isContains = true;
                            break;
                        }
                    }
                    if (!isContains) {
                        c.remove(collectionElement);
                    }
                }
                this.clear();
                for (Object collectionElement : c) {
                    this.add((T) collectionElement);
                }
                return true;
            }

            public int compareTo(Object firstObject, Object secondObject) {
                Number firstNumber = (Number) firstObject;
                Number secondNumber = (Number) secondObject;
                BigDecimal firstDecimal = BigDecimal.valueOf(firstNumber.doubleValue());
                BigDecimal secondDecimal = BigDecimal.valueOf(secondNumber.doubleValue());
                return firstDecimal.compareTo(secondDecimal);
            }
        };
        for (int i = 1; i < setsArray.length; i++) {
            crossSet.retainAll(setsArray[i]);
        }
        return crossSet;
    }

    @SuppressWarnings("unchecked")
    private static <T> Set<T> getUnion(Set<? extends T>... setsArray) {
        Set<T> unionSet = new HashSet<T>(setsArray[0]) {

            @Override
            public boolean addAll(Collection<? extends T> c) {
                T[] collectionArray = (T[]) c.toArray();
                boolean isContains;
                for (T collectionElement : collectionArray) {
                    isContains = false;
                    for (T thisCollectionElement : this) {
                        if (compareTo(collectionElement, thisCollectionElement) == 0) {
                            isContains = true;
                            break;
                        }
                    }
                    if (!isContains) {
                        this.add(collectionElement);
                    }
                }
                return true;
            }

            public int compareTo(Object firstObject, Object secondObject) {
                Number firstNumber = (Number) firstObject;
                Number secondNumber = (Number) secondObject;
                BigDecimal firstDecimal = BigDecimal.valueOf(firstNumber.doubleValue());
                BigDecimal secondDecimal = BigDecimal.valueOf(secondNumber.doubleValue());
                return firstDecimal.compareTo(secondDecimal);
            }
        };
        for (int i = 1; i < setsArray.length; i++) {
            unionSet.addAll(setsArray[i]);
        }
        return unionSet;
    }
}
