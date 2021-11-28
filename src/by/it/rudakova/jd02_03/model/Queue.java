package by.it.rudakova.jd02_03.model;

import by.it._classwork_.jd02_01.service.StoreException;
import by.it.rudakova.jd02_03.Constants;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final Object monitorQueue=new Object();
    private final BlockingDeque<Customer> queue=new LinkedBlockingDeque<>(Constants.QUEUE_CAP);

    public final void add(Customer customer){
       try {
            queue.putLast(customer);
        } catch (InterruptedException e){
           throw new StoreException("QUEUE_INTERRUPTED"+e);
       }
    }

    public Customer extract(){
         {
           return queue.pollFirst();
        }
    }

}
