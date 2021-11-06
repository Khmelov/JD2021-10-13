package by.it.shcharbunou.jd01_11;

public class Runner {

    public static void main(String[] args) {
        ListA<Integer> list = new ListA<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(3123);
        list.add(345);
        list.add(754);
        list.add(76);
        list.add(56);
        list.add(34);
        list.add(9);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        System.out.println(list.get(0));
    }
}
