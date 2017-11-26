package com.rik.producerconsumer;

import java.util.concurrent.Semaphore;

public class Q {

    int item;

    static Semaphore consSemaphore = new Semaphore(0);
    static Semaphore prodSemaphore = new Semaphore(1);;

    void get(){
        try {
            consSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // consumer consuming an item
        System.out.println("Consumer consumed item : " + item);

        // After consumer consumes the item,
        // it releases semProd to notify producer
        prodSemaphore.release();
    }

    void put(int item){
        try {
            prodSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.item = item;

        System.out.println("Producer produced item : " + item);

        // After producer produces the item,
        // it releases semCon to notify consumer
        consSemaphore.release();
    }
}
