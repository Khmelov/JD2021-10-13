package by.it._classwork_.calculator.services;

import by.it._classwork_.calculator.model.Var;

import java.util.HashMap;
import java.util.Map;

public class VarRepository {

    private static final Map<String, Var> mapVar = new HashMap<>();

    public static void save(String name, Var value) {
        mapVar.put(name, value);
    }

    public static Var find(String name) {
        return mapVar.get(name);
    }

    public static void delete(String name) {
        mapVar.remove(name);
    }
}
