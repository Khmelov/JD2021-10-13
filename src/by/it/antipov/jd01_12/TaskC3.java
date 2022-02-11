package by.it.antipov.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Map <Character,Character> brackets = new  HashMap<>();
        Deque <Character> deque = new ArrayDeque<>();
        int counter=0;
        brackets.put('{','}');
        brackets.put('(',')');
        brackets.put('[',']');
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] chars = text.toCharArray();
        for (char charr:chars) {
if(brackets.containsKey(charr)){deque.addFirst(charr);}
            if(brackets.containsValue(charr)&&(deque.isEmpty())){counter++;break;}
if(brackets.containsValue(charr)&&(brackets.get(deque.getFirst())==charr)) {deque.removeFirst();}
        }
if ((deque.isEmpty())&&(counter==0)){System.out.println(true);}
 else System.out.println(false);
    }

}
