package by.it.karmyzov.jd02_02.service;


import by.it.karmyzov.jd02_02.helper.RandomInt;
import by.it.karmyzov.jd02_02.model.Good;

import java.util.HashSet;
import java.util.Set;

public class GoodCreator {
    private static final Set<Good> goods = new HashSet<>();

    static {
        goods.add(new Good("bread", 3));
        goods.add(new Good("seledka", 10));
        goods.add(new Good("vodka", 15));
        goods.add(new Good("voda", 1));
        goods.add(new Good("meat", 20));
        goods.add(new Good("salt", 1));
        goods.add(new Good("sugar", 3));
        goods.add(new Good("vine", 50));
        goods.add(new Good("chiken", 15));
    }
    public static Good randoom () {
        int i = RandomInt.random(0, goods.size() - 1);
        return goods.stream()
                .skip(i)
                .findAny()
                .orElse(new Good());
    }
}
