//package by.it.karmyzov.Test.lLAMBDA;
//
//import by.it.karpovich.Test.Person.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentInfo {
//    public static void main(String[] args) {
//        Students st1 = new Students("Ivan", 'm', 22, 3,8.3);
//        Students st2 = new Students("Nikolay", 'm', 28, 2,6.4);
//        Students st3 = new Students("Elena", 'f', 19, 1,8.9);
//        Students st4 = new Students("Petr", 'm', 35, 4,7.0);
//        Students st5 = new Students("Mariya", 'f', 23, 3,9.1);
//
//        ArrayList<Students> students = new ArrayList<>();
//        students.add(st1);
//        students.add(st2);
//        students.add(st3);
//        students.add(st4);
//        students.add(st5);
//    }
//    void printStudentsOverGrade(ArrayList<Students> a1, double grade){
//        for (Students s: a1) {
//            if(s.avgGrade>grade) {
//                System.out.println(s);
//    }
//    void printStudentsUnderAge(ArrayList<Students> a1, int age){
//        for (Students s: a1) {
//            if(s.age<age) {
//                System.out.println(s);
//    }
//    void printStudentsMixConditions(ArrayList<Students> a1,
//                                    int age,  double grade, char sex){
//        for (Students s: a1) {
//            if(s.avgGrade>grade) {
//                System.out.println(s);
//            }
//
//        }
//
//    }
//}
