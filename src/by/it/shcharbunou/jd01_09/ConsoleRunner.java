package by.it.shcharbunou.jd01_09;

public class ConsoleRunner {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        InputManager inputManager = new InputManager();
        String expression = inputManager.getLine();
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var answer;
        if (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
            while (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
                answer = parser.calc(expression);
                printer.print(answer);
                expression = inputManager.getLine();
            }
        }
    }
}
