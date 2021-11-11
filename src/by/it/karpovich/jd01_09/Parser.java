package by.it.karpovich.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) {
        expression = expression.trim().replace(" ", "");
        //2+2
        String[] parts = expression.split(Patterns.OPERATION, 2);
        String leftPart = parts[0];
        Var left = VarCreator.createVar(leftPart);
        if (Objects.isNull(left)) {
            System.out.println("Неправильная переменная: " + leftPart);
            return null;
        }
        if (parts.length == 1) {
            return left;
        }
        String rightPart = parts[1];
        Var right = VarCreator.createVar(rightPart);
        if (Objects.isNull(right)) {
            System.out.println("Неправильная переменная: " + rightPart);
            return null;
        }

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
        return null;
    }
}
