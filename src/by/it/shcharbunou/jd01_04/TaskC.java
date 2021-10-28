package by.it.shcharbunou.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        String line = InOut.getArrayLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        final String ARRAY_NAME = "V";
        final int COLUMNS_COUNT = 5;
        InOut.printArray(array, ARRAY_NAME, COLUMNS_COUNT);
        mergeSort(array);
        final int OUTPUT_COLUMNS_COUNT = 4;
        InOut.printArray(array, ARRAY_NAME, OUTPUT_COLUMNS_COUNT);
        int firstIndex = binarySearch(array, firstElement);
        int lastIndex = binarySearch(array, lastElement);
        System.out.println("Index of first element=" + firstIndex);
        System.out.println("Index of last element=" + lastIndex);
    }

    private static void mergeSort(double[] array) {
        int arrayLength = array.length;

        if (arrayLength < 2) {
            return;
        }

        int middleIndex = arrayLength / 2;
        double[] leftPart = new double[middleIndex];
        double[] rightPart = new double[arrayLength - middleIndex];

        System.arraycopy(array, 0, leftPart, 0, middleIndex);
        System.arraycopy(array, middleIndex, rightPart, 0, arrayLength - middleIndex);

        mergeSort(leftPart);
        mergeSort(rightPart);

        mergeArrays(array, leftPart, rightPart);
    }

    private static void mergeArrays(double[] array, double[] leftPart, double[] rightPart) {
        int leftPartSize = leftPart.length;
        int rightPartSize = rightPart.length;

        int leftPartCounter = 0, rightPartCounter = 0, mergedArrayCounter = 0;

        while (leftPartCounter < leftPartSize && rightPartCounter < rightPartSize) {
            if (leftPart[leftPartCounter] <= rightPart[rightPartCounter]) {
                array[mergedArrayCounter] = leftPart[leftPartCounter];
                leftPartCounter++;
            } else {
                array[mergedArrayCounter] = rightPart[rightPartCounter];
                rightPartCounter++;
            }
            mergedArrayCounter++;
        }

        while (leftPartCounter < leftPartSize) {
            array[mergedArrayCounter] = leftPart[leftPartCounter];
            leftPartCounter++;
            mergedArrayCounter++;
        }

        while (rightPartCounter < rightPartSize) {
            array[mergedArrayCounter] = rightPart[rightPartCounter];
            rightPartCounter++;
            mergedArrayCounter++;
        }
    }

    private static int binarySearch(double[] array, double value) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int temporaryValueIndex = 0;
        boolean isFound = false;

        while ((leftIndex <= rightIndex) && (!isFound)) {
            temporaryValueIndex = (leftIndex + rightIndex) / 2;
            if (value < array[temporaryValueIndex]) {
                rightIndex = temporaryValueIndex - 1;
            } else if (value > array[temporaryValueIndex]) {
                leftIndex = temporaryValueIndex + 1;
            } else {
                isFound = true;
            }
        }

        return temporaryValueIndex;
    }
}
