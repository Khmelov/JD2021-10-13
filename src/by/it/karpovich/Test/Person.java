package by.it.karpovich.Test;

public class Person {
    /* Здесь по дефолту прописан Public*/ int height; // Высота
    /* Public */ float weight; // Вес

    void say(String str) {
        System.out.println(str);
    }

    // Создаем первый конструктор:
    public Person(int height, float weight) {
        // public должен быть назван так же как и класс. public в принципе можно не писать
        // т.к. по дефолту всегда public стоит. Если класс был бы private/protected, то всё внутри с такой-же защитой.
        // this.height мы работаем с переменной, которая находится в классе.
        this.height = height; // То что после =, это параметр/значение.
        this.weight = weight;
    }
    // В одном нашем классе Person может быть 9999+ конструкторов.
    // Компилятор сам выберет какой конструктор ему использовать конкретно для объекта.

    // Создаем второй пустой конструктор:
    Person () {}

}
