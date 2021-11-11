package by.it.antipov.jd01_12;

import java.util.*;

public class TaskA2 {
  static Set<Integer> getUnion(Set <Integer> left,Set <Integer> right) {
      Set <Integer> newLeft = new HashSet<>(left);
newLeft.addAll(right);
      return newLeft;
  }
  static Set<Integer> getCross (Set <Integer> left,Set <Integer> right) {
      Set <Integer> newLeft = new HashSet<>(left);
      newLeft.retainAll(right);
      return newLeft;
  }

    public static void main(String[] args) {
      List<Integer> array1 =Arrays.asList(1,1,3,4,35,43,5,6,7);
        List <Integer> array2 = Arrays.asList(4, 5, 1, 3, 34, 5, 9, 46, 31);
        Set <Integer> a = new HashSet<>(array1);
        Set <Integer> b = new TreeSet<>(array2);
        System.out.println(getUnion(a,b));System.out.println(getCross(a,b));

    }
}
