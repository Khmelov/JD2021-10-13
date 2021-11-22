package by.it.antipov.jd02_02.model;

import java.util.*;

public class Queue {
    Deque <Customer> queue = new LinkedList<>();
    private final Object monitorQueue = new Object();

    public void addCustomer (Customer customer){
        synchronized (monitorQueue) {
 queue.addLast(customer);
        System.out.println(customer + "got in queue");}
            }


            public  Customer extractCustomer (){
                synchronized (monitorQueue) {
                Customer extractedCustomer = queue.pollFirst();
                System.out.println(extractedCustomer + "got out of queue");
                return  extractedCustomer;}
            }

}
