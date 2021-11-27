package by.it.shcharbunou.jd02_02.multithreaded_store.services.customer_services;

import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Student;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.inventory.ShoppingCart;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.ShoppingCartException;
import by.it.shcharbunou.jd02_02.multithreaded_store.factories.GoodsProducer;
import by.it.shcharbunou.jd02_02.multithreaded_store.factories.PriceListProducer;
import by.it.shcharbunou.jd02_02.multithreaded_store.services.customer_services.CustomerWorker;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Timer;

import java.util.Objects;

public class StudentWorker extends CustomerWorker {

    private final Student student;
    private final GoodsProducer goodsProducer = GoodsProducer.getInstance();
    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();
    private ShoppingCart shoppingCart;
    private final PriceListProducer priceListProducer = PriceListProducer.getInstance();
    private static final int MAX_GOODS_COUNT = 2;
    private static final int MIN_GOODS_COUNT = 0;

    public StudentWorker(Student student) {
        super(student);
        this.student = student;
    }

    @Override
    public void run() {
        enteredStore();
        if (randomizer.randomizeBoolean()) {
            takeCart();
            int goodsCount = randomizer.randomize(MIN_GOODS_COUNT, MAX_GOODS_COUNT);
            for (int i = 0; i < goodsCount; i++) {
                Good good = chooseGoodPriceList();
                int shoppingCartContent = putToCart(good);
                System.out.printf("The cart of customer[%d] (Student) has %d goods...\n", student.getId(), shoppingCartContent);
            }
        } else {
            if (randomizer.randomize(MIN_GOODS_COUNT, 1) == 1) {
                chooseGood();
            }
        }
        goOut();
    }

    @Override
    public Good chooseGoodPriceList() {
        suspender.suspend(randomizer.randomize(100, 300));
        Good good = priceListProducer.randomGood();
        System.out.printf("Customer[%d] (Student) has chosen %s...\n", student.getId(), good.getName());
        return good;
    }

    @Override
    public void enteredStore() {
        System.out.printf("Customer[%d] (Student) entered the store...\n", student.getId());
    }

    @Override
    public Good chooseGood() {
        int choosingTime = randomizer.randomize(500, 2000);
        long startTime;
        long currentTime;
        Good good;
        startTime = System.currentTimeMillis();
        do {
            good = goodsProducer.randomGood();
            currentTime = System.currentTimeMillis();
        } while (timer.isRunning(startTime, currentTime, choosingTime));
        System.out.printf("Customer[%d] (Student) has chosen %s...\n", student.getId(), good.getName());
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("Customer[%d] (Student) has left the shop...\n", student.getId());
    }

    @Override
    public void takeCart() {
        suspender.suspend(randomizer.randomize(100, 300));
        shoppingCart = new ShoppingCart();
        System.out.printf("Customer[%d] (Student) has taken the cart...\n", student.getId());
    }

    @Override
    public int putToCart(Good good) {
        suspender.suspend(randomizer.randomize(100, 300));
        if (Objects.isNull(shoppingCart)) {
            throw new ShoppingCartException("Error: Shopping cart is not taken.");
        }
        shoppingCart.add(good);
        System.out.printf("Customer[%d] (Student) put %s to cart...\n", student.getId(), good.getName());
        return shoppingCart.getContent().size();
    }
}
