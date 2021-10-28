package by.it.karpovich.Test;

public class Main {
    public static void main(String[] args) {
        final float pi = 3.14f; // final - не можем изменять.
        // Если бы поставили перед классом Person, то не было бы наследников Student

        Person dima = new Person(186, 79.9f);
//        dima.height = 186; // int
//        dima.weight = 79.9f; // float
        dima.say("Говорит Дима");
        System.out.println(dima.height); // Был использован первый конструктор Person

        Person artem = new Person(); // Был использован второй конструктор Person
        artem.height = 180;
        artem.weight = 79.9f;
        artem.say("Говорит Артем");
        System.out.println(artem.height);

        Student oleg = new Student(175, 75.4f, 3); // Был использован конструктор Student
        System.out.println("Ссылка: " + oleg);
        System.out.println("Высота: " + oleg.height + "cm");
        System.out.println("Курс студента" + oleg.course);
        oleg.say("Говорит Олег");
    }
}
