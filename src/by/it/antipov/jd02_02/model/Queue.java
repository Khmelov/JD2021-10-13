package by.it.antipov.jd02_02.model;

import java.util.*;

public class Queue {
    Deque <Customer> queue = new LinkedList<>();
    private final Object monitorQueue = new Object();

    public final void addCustomer (Customer customer){
        synchronized (monitorQueue) {
 queue.addLast(customer);
        System.out.println(customer + "got in queue");}
            }


            public  Customer extractCustomer (){
                synchronized (monitorQueue) {
                return   queue.pollFirst();}
            }

}
