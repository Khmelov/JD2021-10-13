package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

public class VarReposistory {

    private Map<String, Var> vars = new HashMap<>();

    public void save(String name, Var value) {
        vars.put(name, value);
    }

    public Var load(String name){
        return vars.get(name);
    }
}
