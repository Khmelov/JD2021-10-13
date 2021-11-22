package by.it.ena.jd02_01.repository;

import by.it._classwork_.jd01_11.ListA;
import by.it.ena.jd02_01.helper.RandomInt;
import by.it.ena.jd02_01.model.Good;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoodCreator {

    private static final Set<Good> goods = new HashSet<>();

    static {
        goods.add(new Good("Milk", 2));
        goods.add(new Good("Salt", 1));
        goods.add(new Good("Sugar", 1));
        goods.add(new Good("Bread", 4));
        goods.add(new Good("Rise", 5));
        goods.add(new Good("Tomato", 4));

    }

    public static Good random() {
        int i = RandomInt.random(0, goods.size() - 1);
        return goods.stream()
                .skip(i)
                .findAny()
                .orElse(new Good());
    }

}
