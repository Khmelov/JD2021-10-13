package by.it.shcharbunou.jd02_03.multithreaded_store.services.inventory_services.behavior;

import by.it.shcharbunou.jd02_03.multithreaded_store.entities.products.Good;

public interface ShoppingCartAction {
    void takeCart();
    int putToCart(Good good);
}
