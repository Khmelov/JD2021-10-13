package by.it.karmyzov.Test.lLAMBDA;

public class Students {

        String name;
        char sex;
        int age;
        int course;
        double avgGrade;

        public Students(String name, char sex, int age, int course, double avgGrade) {
                this.name = name;
                this.sex = sex;
                this.age = age;
                this.course = course;
                this.avgGrade = avgGrade;
        }

        @Override
        public String toString() {
                return "Students{" +
                       "name='" + name + '\'' +
                       ", sex=" + sex +
                       ", age=" + age +
                       ", course=" + course +
                       ", avgGrade=" + avgGrade +
                       '}';
        }
}
