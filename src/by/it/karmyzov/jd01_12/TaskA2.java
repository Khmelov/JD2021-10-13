package by.it.karmyzov.jd01_12;

import java.util.*;

public class TaskA2 {
  private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
      Set<Integer> result=new HashSet<>(one);
      result.addAll(two);
      return result;
  }
    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result=new HashSet<>(one);
        result.retainAll(two);
        return result;
  }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,6,6));
        HashSet<Integer> hashSet  = new HashSet<>(Arrays.asList(9,8,7,2,3,3,4,4,5,5,6,6));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));




    }}
//        Integer[] array1 = {1,1,2,2,3,3,4,4,5,5,6,6,7,7};
//        Integer[] array2 = {9,9,8,8,7,7,6,6,5,5,4,4,};
//        List<Integer> integers1 = Arrays.asList(array1);
//        List<Integer> integers2 = Arrays.asList(array2);
//      //  Set<Integer> hashSet = new HashSet<>(array1);
//       // Set<Integer> threeSet = new HashSet<>(array2);
//    }
//    private static  Set<Integer> getUion(Set<Integer> left, Set<Integer> right) {
//        HashSet<Integer> result = new HashSet<>(left);
//        result.retainAll(right);
//        return left;
//    }
//
//}
