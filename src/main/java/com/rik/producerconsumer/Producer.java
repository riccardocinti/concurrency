package com.rik.producerconsumer;


public class Producer implements Runnable {

    Q q;

    Producer(Q q){
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            q.put(i);
        }
    }
}
