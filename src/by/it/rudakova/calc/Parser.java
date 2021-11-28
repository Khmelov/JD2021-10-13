package by.it.rudakova.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Map<String,Integer> mapPriority=Map.of(
            "=",0,
            "+",1,
            "-",1,
            "*",2,
            "/",2
            );

    private final VarRepository varRepository;
    private final VarCreator varCreator;

    public Parser(VarRepository varRepository){
        this.varRepository=varRepository;
        this.varCreator=new VarCreator(varRepository);
    }

    Var calc(String expression)throws CalcException {
        expression=expression.trim().replace(" ","");
        String [] operand=expression.split(Patterns.OPERATION);
        List<String> operands=new ArrayList<>(List.of(operand));
        Matcher matcherOperations=Pattern.compile(Patterns.OPERATION).matcher(expression);
        List<String> operations=new ArrayList<>();
        while(matcherOperations.find()){
            String operation=matcherOperations.group();
            operations.add(operation);
        }
        while(!operations.isEmpty()){
            int index=getIndexOperation(operations);
            String left=operands.remove(index);
            String right=operands.remove(index);
            String operation=operations.remove(index);
            Var var=calcOneOperation(left,operation,right);
            operands.add(index,var.toString());
        }
        return varCreator.createVar(operands.get(0));


    }

    private Var calcOneOperation(String left, String operation, String right) throws CalcException {
        Var first=varCreator.createVar(right);
        if(Objects.isNull(first)){
            throw new CalcException("Wrong variable "+right);
        }
        if(operation.equals("=")){
            varRepository.save(left,first);
            return first;
        }

        Var second=varCreator.createVar(left);
        switch (operation){
            case "+": return second.add(first);
            case "-": return second.sub(first);
            case "*": return second.mul(first);
            case "/": return second.div(first);

        }

        throw new CalcException("Something went wrong");

    }

    private int getIndexOperation(List<String> operations) {
        int index=-1;
        int priority=-1;
        for(int i=0;i<operations.size();i++){
            String operation=operations.get(i);
            Integer currentPriority=mapPriority.get(operation);
            if(currentPriority>priority){
                priority=currentPriority;
                index=i;
            }
        }
        return index;
    }
}

