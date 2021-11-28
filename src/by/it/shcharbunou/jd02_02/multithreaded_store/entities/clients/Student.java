package by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients;

public class Student extends Customer {

    private final int minGoodsCount = 0;
    private final int maxGoodsCount = 2;

    public Student(int id) {
        super(id);
    }

    @Override
    public int getMinGoodsCount() {
        return minGoodsCount;
    }

    @Override
    public int getMaxGoodsCount() {
        return maxGoodsCount;
    }
}
