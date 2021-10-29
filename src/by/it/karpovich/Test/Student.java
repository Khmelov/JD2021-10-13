package by.it.karpovich.Test;

public class Student extends Person {
    // у Student есть доступ к Person с защитой public и protected
    int course; // на каком курсе студент

    public Student(int height, float weight, int course) {
        super(height, weight); //супер нужен, чтобы вызывать нужные параметры из конструктора Person.
        this.course = course;

    }
}
