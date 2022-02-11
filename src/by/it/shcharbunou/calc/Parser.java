package by.it.shcharbunou.calc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.shcharbunou.jd01_09.Samples.OPERATION;

public class Parser {

    protected Var calc(String expression) {
        expression = expression.replaceAll(" ", "");
        String[] stringOperands = expression.split(OPERATION);
        if (stringOperands.length == 2) {
            Var firstOperand = VarCreator.createVar(stringOperands[0]);
            Var secondOperand = VarCreator.createVar(stringOperands[1]);
            if (!Objects.isNull(firstOperand) && !Objects.isNull(secondOperand)) {
                Pattern operationPattern = Pattern.compile(OPERATION);
                Matcher operationMatcher = operationPattern.matcher(expression);
                if (operationMatcher.find()) {
                    return switch (operationMatcher.group()) {
                        case "+" -> firstOperand.add(secondOperand);
                        case "-" -> firstOperand.sub(secondOperand);
                        case "*" -> firstOperand.mul(secondOperand);
                        case "/" -> firstOperand.div(secondOperand);
                        default -> null;
                    };
                }
            }
        }
        return null;
    }
}
