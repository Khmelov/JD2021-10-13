package by.it._classwork_.calculator.services;


import by.it._classwork_.calculator.constants.Patterns;
import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.creators.Operation;
import by.it._classwork_.calculator.services.creators.VarCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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


    private final VarCreator varCreator;

    public Parser(VarRepository varRepository) {
        this.varCreator = new VarCreator();
    }

    public Var calc(String expression) {
        expression = expression.trim().replaceAll("\\s*", "");
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

    private Var calcOneOperation(String stringLeft, String operationSymbol, String stringRight) {
        if (operationSymbol.equals(SubStrings.ASSIGN)) {
            VarRepository.delete(stringLeft);
        }
        Var left = varCreator.createVar(stringLeft);
        Var right = varCreator.createVar(stringRight);
        Operation operation = new Operation(left, operationSymbol, right);
        return operation.getResult();
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
