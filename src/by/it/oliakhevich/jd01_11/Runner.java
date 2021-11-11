package by.it.oliakhevich.jd01_11;

public class Runner {
    public static void main(String[] args) {
        ListA<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println("get(1)="+list.get(1));


    }
}
