package by.it._classwork_.calc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final VarRepository varRepository;

    private final VarCreator varCreator;

    public Parser(VarRepository varRepository) {
        this.varRepository = varRepository;
        this.varCreator = new VarCreator(varRepository);
    }

    Var calc(String expression) {
        expression = expression.trim().replace(" ", "");
        //2+2
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return varCreator.createVar(expression);
        }
        String rightPart = parts[1];
        Var right = varCreator.createVar(rightPart);
        if (Objects.isNull(right)) {
            System.out.println("Incorrect variable " + rightPart);
            return right;
        }

        String leftPart = parts[0];
        if (expression.contains("=")) {
            String name = leftPart;
            varRepository.save(name, right);
            return right;
        }
        Var left = varCreator.createVar(leftPart);
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOperation.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        System.out.println("Something stupid");
        return null;
    }
}
