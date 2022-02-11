package by.it.oliakhevich.jd01_04;

public class TaskC {
        static void buildOneDimArray (String line){
            double[] array = InOut.getArray(line);
            double startNumber = array[0];
            double lastNumber = array[array.length - 1];
            InOut.printArray(array, "V", 5);
            // Helper.sort(array);
            InOut.printArray(array, "V", 4);
            for (int i = 0; i < array.length; i++) {
                if (array[i] == startNumber) {
                    System.out.println("first element=" + i);
                    break;
                }


            }
        }
       // static void mergeSort ( double[] array)
    }

