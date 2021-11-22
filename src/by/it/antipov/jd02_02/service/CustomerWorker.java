package by.it.antipov.jd02_02.service;


import by.it.antipov.jd02_02.Helper.Randomizer;
import by.it.antipov.jd02_02.model.Customer;
import by.it.antipov.jd02_02.model.Good;
import by.it.antipov.jd02_02.model.ShoppingCart;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {
    private final Customer customer;
ShoppingCart customerCart;

   public CustomerWorker()  {
        throw new StoreException("customer is not existed");
    }
    public CustomerWorker(Customer customer){
this.customer=customer;
    }

    public void run() {
        enteredStore();
        int a= Randomizer.Randomizer(0,10);
        int b= Randomizer.Randomizer(2,5);
        if (a>5){takeCart();}
        if (customer.isHasCart()){
            GoodCreator goodCreator = new GoodCreator();
            for (int i = 0; i <b; i++) {putToCart(goodCreator.addGood());}}
        goOut();
    }
    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store");
    }

    @Override
    public Good chooseGood() {
        try {
            Thread.sleep(Randomizer.Randomizer(500,2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GoodCreator goodCreator = new GoodCreator();
        System.out.println(customer+" chose "+goodCreator.addGood());
       return goodCreator.addGood();
    }

    @Override
    public void goOut() {
        System.out.println(customer+" left the store");
    }

    @Override
    public void takeCart() {
        customerCart=new ShoppingCart();
        customer.setHasCart(true);
        System.out.println(customer+" took cart ");
    }

    @Override
    public int putToCart(Good good) {
customerCart.cartAdd(good);
        System.out.println(customer+" put "+good+" into cart");
        return customerCart.cartSize();
    }
}
