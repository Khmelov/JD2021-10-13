package by.it._classwork_.jd02_03.service;

import by.it._classwork_.jd02_03.helper.RandomInt;
import by.it._classwork_.jd02_03.model.Good;

import java.util.HashSet;
import java.util.Set;

public class GoodCreator {

    //TODO non static - need repo
    private static final Set<Good> goods = new HashSet<>();

    //stub
    static {
        goods.add(new Good("bred", 2));
        goods.add(new Good("vodka", 20));
        goods.add(new Good("sugar", 3));
        goods.add(new Good("salt", 1));
    }

    public static Good random() {
        int i = RandomInt.random(0, goods.size() - 1);
        return goods.stream()
                .skip(i)
                .findAny()
                .orElse(new Good());
    }
}
