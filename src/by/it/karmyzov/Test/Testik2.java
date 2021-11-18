package by.it.karmyzov.Test;

import java.util.*;

public class Testik2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 1000);
        Employee emp2 = new Employee(15, "Ivan", "Petrovov", 1020);
        Employee emp3 = new Employee(123, "Ivan", "XIov", 1500);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println(list);
        Collections.sort(list, new NameComparator());
        System.out.println(list);
    }

}

class Employee {//implements Comparable<Employee> {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", salary=" + salary +
               '}';
    }
//
//    @Override
//   public int compareTo(Employee anotherEmp) {
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//        return  this.id-anotherEmp.id;
//    return this.id.compareTo(anotherEmp.id);
//    int res =  this.name.compareTo(anotherEmp.name);
//    if (res==0){
//        res=this.surname.compareTo(anotherEmp.surname);
//    }
//    return res;
//    }
}
class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.id == emp2.id) {
            return 0;
        } else if (emp1.id < emp2.id) {
            return -1;
        } else {
            return 1;
        }
    }
}
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
//    int res =  emp1.name.compareTo(emp2.name);
//    if (res==0){
//        res=emp1.surname.compareTo(emp2.surname);
//    }
//    return res;
//    }
}}