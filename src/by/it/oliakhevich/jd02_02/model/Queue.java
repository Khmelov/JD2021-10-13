package by.it.oliakhevich.jd02_02.model;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {
    BlockingDeque<Customer> queue = new LinkedBlockingDeque<>(30);


    public final void addCustomer (Customer customer){
        queue.addLast(customer);
        System.out.println(customer + "got in queue");
    }


    public Customer extractCustomer (){
        return   queue.pollFirst();
    }
}
