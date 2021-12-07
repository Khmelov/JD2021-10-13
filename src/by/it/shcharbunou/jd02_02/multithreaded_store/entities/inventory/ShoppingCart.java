package by.it.shcharbunou.jd02_02.multithreaded_store.entities.inventory;

import by.it.shcharbunou.jd02_02.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.ShoppingCartException;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final int MAX_CAPACITY = 5;
    private List<Good> content;

    public ShoppingCart() {
        content = new ArrayList<>(MAX_CAPACITY);
    }

    public List<Good> getContent() {
        return content;
    }

    public void add(Good good) {
        if (content.size() < 6) {
            content.add(good);
        } else {
            throw new ShoppingCartException("Error: Shopping cart is full.");
        }
    }

    public void setContent(List<Good> content) {
        this.content = content;
    }
}
