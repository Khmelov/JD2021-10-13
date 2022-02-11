package by.it._classwork_.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<String, Integer> mapPriority = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private final VarRepository varRepository;

    private final VarCreator varCreator;

    public Parser(VarRepository varRepository) {
        this.varRepository = varRepository;
        this.varCreator = new VarCreator(varRepository);
    }

    Var calc(String expression) throws CalcException {
        expression = expression.trim().replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(List.of(parts));
        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherOperation.find()) {
            String operation = matcherOperation.group();
            operations.add(operation);
        }
        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var var = calcOneOperation(left, operation, right);
            operands.add(index, var.toString());
        }
        return varCreator.createVar(operands.get(0));
    }

    private Var calcOneOperation(String leftPart, String operation, String rightPart) throws CalcException {
        //2+2
        Var right = varCreator.createVar(rightPart);
        if (Objects.isNull(right)) {
            throw new CalcException("Incorrect variable " + rightPart);
        }

        if (operation.equals("=")) {
            varRepository.save(leftPart, right);
            return right;
        }
        Var left = varCreator.createVar(leftPart);
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
        throw new CalcException("Something stupid");
    }


    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            Integer currentPriority = mapPriority.get(op);
            if (currentPriority > priority) {
                priority = currentPriority;
                index = i;
            }
        }
        return index;
    }
}
