package by.it.karpovich.jd01_14;

import java.io.*;
import java.util.Locale;

public class TaskA {

    public static final String BIN_FILE_NAME = "dataTaskA.bin";
    public static final String TXT_FILE_NAME = "resultTaskA.txt";

    // Создаем функцию, которая будет определять текущее расположение в которой находится наш Класс:
    private static String directory(Class<?> cl) {
        Locale.setDefault(Locale.US);
        String getDirection = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDirection = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return getDirection + classDirection;
        //user.dir - указывает на наш "каталог проекта"
        /*          Чтобы не писать разделитель \\ - Windows, // - Линукс, мы используем готовую штуку separator.    */

    }


    public static void main(String[] args) {
        //System.out.println(directory(TaskA.class));

        // Выбираем каталог в который будем записывать файлы:
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(directory(TaskA.class)+BIN_FILE_NAME)));
            // Файловый поток создан, теперь сюда можно записывать данные.
            for (int i = 0; i < 20; i++) {
               dos.writeInt((int) (Math.random() * 20));
            }
        } catch (IOException e) { // Поведение одинаковое, поэтому мы сомкнули всё в один блок.
            e.printStackTrace();
        }
        // Теперь закрываем файл:
        finally {

            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            try (DataInputStream inputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(directory(TaskA.class)+BIN_FILE_NAME)));
            PrintWriter out2 = new PrintWriter(new FileWriter(directory(TaskA.class)+TXT_FILE_NAME)))

            {

                // Делаем чтение:
                double sum = 0;
                double count = 0; // Количество прочитанных элементов.
// Читаем всех по очереди:
                while (inputStream.available() >0 ) { //Пока есть что-то в файле
                    int i = inputStream.readInt(); // То мы читаем каждое число
                    System.out.print(i + " "); // и печатаем его на экран
                    out2.print(i + " ");
                    sum = sum + i;
                    count++;
                }
                System.out.println("\navg=" +sum/count);
                out2.print("\navg=" +sum/count);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
