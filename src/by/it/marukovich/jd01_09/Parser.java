package by.it.marukovich.jd01_09;

import by.it._classwork_.jd01_09.Var;

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
            System.out.println("Incorrect variable " + leftPart);
            return left;
        }
        if (parts.length == 1) {
            return left;
        }
        String rightPart = parts[1];
        Var right = VarCreator.createVar(rightPart);
        if (Objects.isNull(right)) {
            System.out.println("Incorrect variable " + rightPart);
            return right;
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
        System.out.println("Something stupid");
        return null;
    }
}
