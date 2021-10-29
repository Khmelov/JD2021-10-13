package by.it.karpovich.Test;

public class Main {
    public static void main(String[] args) {
        final float pi = 3.14f; // final - не можем изменять.
        // Если бы поставили перед классом Person, то не было бы наследников Student

        Person dima = new Person(186, 79.9f);
//        dima.height = 186; // int
//        dima.weight = 79.9f; // float
        dima.say("Говорит Дима");
        System.out.println("Рост составляет: " + dima.height); // Был использован первый конструктор Person
        System.out.println("Вес составляет: " + dima.weight);

        Person artem = new Person(); // Был использован второй конструктор Person
        artem.height = 180;
        artem.weight = 79.9f;
        artem.say("Говорит Артем");
        System.out.println("Рост составляет: " + artem.height);
        System.out.println("Вес составляет: " + artem.weight);

        Student oleg = new Student(175, 75.4f, 3); // Был использован конструктор Student
        oleg.say("Говорит Олег");
        System.out.println("Ссылка: " + oleg);
        System.out.println("Высота: " + oleg.height + "cm");
        System.out.println("Курс студента: " + oleg.course);

        System.out.println("Pi = " + pi);
    }
}
