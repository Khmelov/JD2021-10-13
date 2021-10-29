package by.it.shcharbunou.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of people:");
        int n = getNumber(scanner);
        String[] lastNames = new String[n];
        fillStringArray(lastNames, scanner);
        final int quarterCount = 4;
        int[][] salaries = new int[lastNames.length][quarterCount];
        fillQuarterSalariesMatrix(salaries, lastNames, scanner);
        printTable(salaries, lastNames);
    }

    private static int getNumber(Scanner scanner) {
        boolean isCorrect;
        int value = 0;
        do {
            isCorrect = true;
            try {
                value = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be integer. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        return value;
    }

    private static void fillStringArray(String[] stringArray, Scanner scanner) {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Enter last name of the " + (i + 1) + " person");
            stringArray[i] = scanner.next();
        }
    }

    private static void fillQuarterSalariesMatrix(int[][] salaries, String[] lastNames, Scanner scanner) {
        boolean isCorrect;
        for (int i = 0; i < salaries.length; i++) {
            int[] quarterSalariesArray;
            String quarterSalariesArrayLine;
            do {
                isCorrect = true;
                System.out.println("Enter salary of " + lastNames[i] + ":");
                quarterSalariesArrayLine = getQuarterSalariesArrayLine(scanner);
                quarterSalariesArray = getQuarterSalariesArray(quarterSalariesArrayLine);
                if (quarterSalariesArray.length != 4) {
                    System.out.println("Error: Only 4 quarters! Try again:");
                    isCorrect = false;
                }
            } while (!isCorrect);
            salaries[i] = quarterSalariesArray;
        }
    }

    private static String getQuarterSalariesArrayLine(Scanner scanner) {
        boolean isCorrect;
        String line;
        do {
            isCorrect = true;
            line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (!(Character.isDigit(line.charAt(i))) && !(Character.isSpaceChar(line.charAt(i)))
                        && !(line.charAt(i) == '-') && !(line.charAt(i) == '+')) {
                    System.out.println("Error: Array must be integer type. Try again:");
                    isCorrect = false;
                    break;
                }
                if ((line.charAt(i) == '-') || (line.charAt(i) == '+')) {
                    if (!(Character.isDigit(line.charAt(i + 1)))) {
                        System.out.println("Error: The sign must not be separated by a space. Try again:");
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (line.equals("")) {
                isCorrect = false;
            }
        } while (!isCorrect);

        return line;
    }

    protected static int[] getQuarterSalariesArray(String line) {
        line = line.trim();
        String[] stringsArray = line.split(" ");
        int[] preparedArray = new int[stringsArray.length];
        for (int i = 0; i < preparedArray.length; i++) {
            preparedArray[i] = Integer.parseInt(stringsArray[i]);
        }
        return preparedArray;
    }

    private static void printTable(int[][] salaries, String[] lastNames) {
        final String DELIMITER = "-------------------------------------------------------------------------";
        System.out.println(DELIMITER);
        System.out.println("Фамилия         Квартал1     Квартал2     Квартал3     Квартал4     Итого     ");
        System.out.println(DELIMITER);
        int temporaryAmount = 0;
        int fullAmount = 0;
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%14s: ", lastNames[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                System.out.printf("%-13d", salaries[i][j]);
                temporaryAmount += salaries[i][j];
                fullAmount += salaries[i][j];
            }
            System.out.printf("%-13d", temporaryAmount);
            temporaryAmount = 0;
            System.out.print("\n");
        }
        System.out.println(DELIMITER);
        System.out.printf("%-16s%-13d", "Итого", fullAmount);
        System.out.print("\n");
        double averageSalary = (double) fullAmount / (salaries.length * salaries[0].length);
        System.out.printf("%-16s%-14.4f", "Средняя", averageSalary);
    }
}
