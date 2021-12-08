package by.it.oliakhevich.jd02_02.service;

import by.it.oliakhevich.jd02_03.helper.Randomize;
import by.it.oliakhevich.jd02_03.model.Good;

public class GoodCreator {
    public Good addGood() {
        switch (Randomize.Randomize(0,4)) {
            case 0:
                Good bread = new Good("bread", 4);
                return bread;
            case 1:
                Good vodka = new Good("vodka", 5);
                return vodka;
            case 2:
                Good meat = new Good("meat", 7);
                return meat;
            case 3:
                Good water = new Good("water", 1);
                return water;
            case 4:
                Good milk = new Good("milk", 3);
                return milk;
        }
        return new Good("nothing",0);
    }
}
