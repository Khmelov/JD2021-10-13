package by.it.karmyzov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

import static by.it.karmyzov.jd01_12.TaskB3.process;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrPeople = new ArrayList<>();
        arrPeople.add("Nikolayy");
        arrPeople.add("Vasilij");
        arrPeople.add("Viktor");
        arrPeople.add("Alexandr");
        arrPeople.add("Vladimir");
        arrPeople.add("Konstantin");
        arrPeople.add("Alexei");
        arrPeople.add("Ivan");

        LinkedList<String> linkPeple = new LinkedList<>();
        linkPeple.add("Galina");
        linkPeple.add("Ekaterina");
        linkPeple.add("Olga");
        linkPeple.add("Tatiana");
        linkPeple.add("Natalia");
        linkPeple.add("Mariya");
        linkPeple.add("Zinaida");
        linkPeple.add("Valentina");

        String firstname = process(arrPeople);
        String lastname = process(linkPeple);
        System.out.println(firstname);
        System.out.println(lastname);

    }
    static String process (ArrayList<String> people) {
        while (people.size() > 1) {
            String next = people.remove(0);
            people.remove(0);
            people.add(next);
        }
        return people.get(0);
    }

    static String process (LinkedList<String> people) {
        while (people.size() > 1) {
            String next = people.pollFirst();
            people.pollFirst();
            people.addLast(next);
        }
        return people.get(0);
    }
}