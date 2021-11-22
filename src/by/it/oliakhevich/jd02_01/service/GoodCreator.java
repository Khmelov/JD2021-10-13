package by.it.oliakhevich.jd02_01.service;

import by.it.oliakhevich.jd02_01.helperstore.RandomInt;
import by.it.oliakhevich.jd02_01.model.Good;

import java.util.HashSet;
import java.util.Set;

public class GoodCreator {
    private static final Set<Good> goods = new HashSet<>();

    static {
        goods.add(new Good("sugar",4));
        goods.add(new Good("butter",2));
        goods.add(new Good("vodka",20));
        goods.add(new Good("salt",10));
        goods.add(new Good("bred",5));

    }
    public static Good random(){
        int i = RandomInt.random(0,goods.size()-1);
        return goods.stream().skip(i).findAny().orElse(new Good());
    }
}
