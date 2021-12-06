package by.it.antipov.jd01_12;

import java.util.*;

public class TaskC2 {
    static Set<Double> getUnion(Set...sets) {
        parser(sets[0]);
        Set <Double> newLeft = new HashSet<>(sets[0]);
        for (int i = 1; i <sets.length ; i++) {
            parser(sets[i]);
           newLeft.addAll(sets[i]);
        }
        return newLeft;
    }
    static Set<Double> getCross (Set ... sets) {
        parser(sets[0]);
        Set <Double> newLeft = new HashSet<>(sets[0]);
        for (int i = 1; i <sets.length ; i++) {
            parser(sets[i]);
            newLeft.retainAll(sets[i]);
        }
        return newLeft;
    }
    public  static  void parser(Set a){
            Object[] objects =  a.toArray();
            for (int j = 0; j < objects.length; j++) {
                objects[j]=Double.parseDouble(String.valueOf(objects[j]));
            }
       a.clear(); a.addAll(List.of(objects));
    };
    public static void main(String[] args) {
        List<Long> array1 = Arrays.asList(1L,1L,3L,4L,35L,43L,5L,6L,7L);
        List <Byte> array2 = Arrays.asList((byte)4,(byte) 5, (byte)1, (byte)3, (byte)34, (byte)5,(byte) 9, (byte)46, (byte)31);
        List <Float> array3 = Arrays.asList(8.0F, 35.0F, 34.0F, 3.0F, 3.0F, 14.0F);
        Set <Long> a = new HashSet<>(array1);
        Set <Byte> b = new TreeSet<>(array2);
        Set <Float> c = new TreeSet<>(array3);
        System.out.println(getUnion(a,b));System.out.println(getCross(a,b));

    }
}

