package by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients;

import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.CustomerException;

import java.util.Objects;

public class Student extends Customer {

    private final int id;

    public Student() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
