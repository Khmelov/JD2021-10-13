package by.it.ena.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepository {

    private final Map<String, Var> vars = new HashMap<>();

    public void save(String name, Var value) {
        vars.put(name, value);
    }

    public Var load(String name){
        return vars.get(name);
    }
}