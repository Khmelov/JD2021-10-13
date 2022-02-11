package by.it.karmyzov.Test;

public class Ternory {
    public static void main(String[] args) {


//
//        String s = "VASYA BELII";
//StringBuilder sb = new StringBuilder();
//sb.append(s);
//sb = sb.reverse();
//        System.out.println(sb);
//    }}
        //ITVDN.com 2 из ТОП 20 тестовых заданий на интервью для Java разработчика

        String st = "Учимся программировать";

        char symbols[] = st.toCharArray();  // конвертируем строку в массив символов, затем выводим символы на экран в обратном порядке

        for(int x= symbols.length-1; x>=0; x--) {

            System.out.print(symbols [x]);

        }

    }

}
