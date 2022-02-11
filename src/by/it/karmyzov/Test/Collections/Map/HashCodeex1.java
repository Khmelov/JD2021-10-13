package by.it.karmyzov.Test.Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeex1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student(" Zaur", "Tregulov", 3);
        Student st2 = new Student("Sergio", "Belii", 5);
        Student st3 = new Student(" Kalar", "Trooov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.2);
        map.put(st3, 6.5);
        System.out.println(map);
        Student st4 = new Student(" Zaur", "Tregulov", 3);
        Student st5 = new Student(" Igor", "Sidorovv", 4);
//
//        boolean result = map.containsKey(st4);
//        System.out.println("result =" + result);
//        System.out.println(st1.equals(st4));
        System.out.println(st1.hashCode());
        System.out.println(st4.hashCode());
        for (Map.Entry<Student, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}

class Student implements Comparable<Student> {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }




    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}


