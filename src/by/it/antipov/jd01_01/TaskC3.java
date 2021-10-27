package by.it.antipov.jd01_01;
/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
import java.util.Scanner;
class TaskC3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earthWeight = sc.nextInt();
System.out.println(getWeight(earthWeight));
    }
static double getWeight(int weight) {
    double weightM; // спроси почему вылетает ошибка если не создавать weightM и делать weight=(double)(((weightM+(10-weightM%10))/1000))??
weightM=(int) (weight*3.86/9.81*1000);
    if ((weightM%10)>=5) weightM=(double)(((weightM+(10-weightM%10))/1000));
    else  weightM=(double)(weightM/1000);
        return  weightM;
}
}
